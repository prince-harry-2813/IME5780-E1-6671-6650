package renderer;

import elements.Camera;
import elements.LightSource;
import geometries.Intersectable;
import geometries.Intersectable.GeoPoint;
import primitives.*;
import scene.Scene;

import java.util.List;

import static primitives.Util.alignZero;

public class Render {
    /**
     *
     */
    private static final double DELTA = 0.1;
    ImageWriter _imageWriter;
    Scene _scene;

    /**
     * Ctor for render accept scene to compile the objects init the image by image writer
     *
     * @param imageWriter instance of ImageWriter class to crate new image
     * @param scene       instance of Scene to handled with essence of 3D and light in the picture
     */
    public Render(ImageWriter imageWriter, Scene scene) {
        this._imageWriter = imageWriter;
        this._scene = scene;
    }

    private boolean unshaded(LightSource light, Vector l, Vector n, GeoPoint gp) {
        Vector lightDirection = l.scale(-1);
        Vector delta = n.scale(n.dotProduct(lightDirection) > 0 ? DELTA : -DELTA);
        Point3D point = gp.point.add(delta);
        Ray lightRay = new Ray(point, lightDirection);
        List<GeoPoint> intersections = _scene.get_geometries().findIntersections(lightRay);
        if (intersections == null)
            return true;
        double lightDistance = light.getDistance(gp.point);
        for (GeoPoint geoP : intersections) {
            if (alignZero(geoP.point.distance(gp.point) - lightDistance) <= 0)
                return false;
        }
        return true;
    }

    /**
     * combine the scene in the image
     */
    public void renderImage() {
        Camera camera = _scene.get_camera();
        Intersectable geometries = _scene.get_geometries();
        java.awt.Color background = _scene.get_background().getColor();
        int nx = _imageWriter.getNx();
        int ny = _imageWriter.getNy();
        double distance = _scene.get_distance(), width = _imageWriter.getWidth(), height = _imageWriter.getHeight();

        for (int i = 0; i < ny; i++) { //row
            for (int j = 0; j < nx; j++) { //column
                Ray ray = camera.constructRayThroughPixel(nx, ny, j, i, distance, width, height);
                List<GeoPoint> intersectionPoints = geometries.findIntersections(ray);
                if (intersectionPoints == null) {
                    _imageWriter.writePixel(j, i, background);
                } else {
                    GeoPoint closetPoint = getClosestPoint(intersectionPoints);
                    _imageWriter.writePixel(j, i, calcColor(closetPoint).getColor());
                }
            }
        }
    }

    private boolean sign(double x) {
        return (x > 0d);
    }

    /**
     * @param p point on geometry object
     * @return Ip the color of pixel that return by light reflection and Phong reflection model
     */
    private Color calcColor(GeoPoint p) {
        Color color = _scene.get_ambientLight().get_intensity(); // Ka * Ia
        color = color.add(p.getGeometry().get_emission()); //  + Ie
        Vector v = p.point.subtract(_scene.get_camera().getP0()).normalize();
        Vector n = p.geometry.getNormal(p.point);
        Material material = p.geometry.get_material();
        if (material != null) {
            int nShininess = material.get_nShininess();
            double kd = material.get_kD(), ks = material.get_kS();

            if (_scene.get_lights() != null) {
                for (LightSource lightS : _scene.get_lights()) {
                    Vector l = lightS.getL(p.point);
                    double nl = alignZero(n.dotProduct(l)), nv = alignZero(n.dotProduct(v));
                    if (sign(nl) == sign(nv))
                        if (unshaded(lightS, l, n, p)) {
                            Color lightIntensity = lightS.getIntensity(p.getPoint());
                            color = color.add(calcDiffusive(kd, nl, lightIntensity), calcSpecular(ks, l, n, nl, v, nShininess, lightIntensity));

                        }
                }
            }
        }
        return color;
    }

    /**
     * @param kd diffusive component
     * @param nl cos -> n dot product l
     * @param ip color intensity of reflection
     * @return diffused color light reflection
     */
    private Color calcDiffusive(double kd, double nl, Color ip) {
        nl = Math.abs(nl);
        return ip.scale(nl * kd);
    }

    /**
     * @param ks         specular component
     * @param l          direction of light to point on object
     * @param n          normal to object surface
     * @param nl         cos -> n dot product l
     * @param v          direction from camera point to object point
     * @param nShininess shininess level
     * @param ip         color intensity of reflection
     * @return specular color light reflection
     */
    private Color calcSpecular(double ks, Vector l, Vector n, double nl, Vector v, int nShininess, Color ip) {
        Vector R = l.add(n.scale(-2 * nl));
        double oppositeVR = -alignZero(R.dotProduct(v));
        if (oppositeVR <= 0) return Color.BLACK;
        return ip.scale(ks * Math.pow(oppositeVR, nShininess));
    }

    /**
     * @param geoPoints list of camera intersection points in geo object.
     * @return closet point to camera position
     */
    public GeoPoint getClosestPoint(List<GeoPoint> geoPoints) {
        GeoPoint pResult = null;
        double distance = Double.MAX_VALUE;
        Point3D p0 = _scene.get_camera().getP0();
        for (GeoPoint partOf : geoPoints) {
            double d = p0.distance(partOf.point);
            if (d < distance) {
                distance = d;
                pResult = partOf;
            }

        }
        return pResult;
    }

    /**
     * util method to crate grid line over picture
     *
     * @param interval int' X int' size of Grid
     * @param color    color og the stripes
     */
    public void printGrid(int interval, java.awt.Color color) {
        int nx = _imageWriter.getNx(), ny = _imageWriter.getNy();
        for (int i = 0; i < ny; i++) {
            for (int j = 0; j < nx; j++) {
                if (i % interval == 0 || j % interval == 0) {
                    _imageWriter.writePixel(j, i, color);
                }
            }
        }
    }

    /**
     * calling to print image method in image writer
     */
    public void writeToImage() {
        this._imageWriter.writeToImage();
    }
}
