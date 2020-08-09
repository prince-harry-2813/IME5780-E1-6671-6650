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
    private static final int MAX_CALC_COLOR_LEVEL = 10;
    /**
     * MIN value if it reach below this stop calculate reflection cause it add 0 to color
     */
    private static final double MIN_CALC_COLOR_K = 0.003;
    /**
     * factor for scale the normal to object, solve the floating point problem
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
        Vector lightDirection = l.scale(-1);  // direction of light toward the gPoint
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
     * combine the scene in a image
     */
    public void renderImage() {
        Camera camera = _scene.get_Camera();
        Intersectable geometries = _scene.get_geometries();
        java.awt.Color background = _scene.get_Background().getColor();
        int nx = _imageWriter.getNx();
        int ny = _imageWriter.getNy();
        double distance = _scene.get_Distance(), width = _imageWriter.getWidth(), height = _imageWriter.getHeight();

        for (int i = 0; i < ny; i++) { //row
            for (int j = 0; j < nx; j++) { //column
                Ray ray = camera.constructRayThroughPixel(nx, ny, j, i, distance, width, height);
                GeoPoint closestPoint = findClosestIntersection(ray);
                _imageWriter.writePixel(j, i, closestPoint == null ?
                        background :
                        calcColor(closestPoint, ray).getColor());

            }
        }
    }

    /**
     * @param x
     * @return
     */
    private boolean sign(double x) {
        return (x > 0d);
    }

    /**
     * construct second ray that reflected from object by first ray
     *
     * @param rayST  first ray that intersect object
     * @param point  of intersection by first ray on object
     * @param normal to object at point
     * @return new reflected ray
     */
    private Ray constructReflectedRay(Ray rayST, Point3D point, Vector normal) {
        Vector v = rayST.getDir();
        double vn = v.dotProduct(normal);
        if (vn == 0)
            return null;
        Vector r = v.add(normal.scale(-2 * vn));
        return new Ray(point, r, normal);
    }

    /**
     * construct second ray that refracted through the intersectable object
     *
     * @param point  of intersection by first ray on object
     * @param raySt  first ray that intersect object
     * @param normal to object at point
     * @return
     */
    private Ray constructRefractedRay(Point3D point, Ray raySt, Vector normal) {
        return new Ray(point, raySt.getDir(), normal);
    }

    /**
     * @param p point on geometry object
     * @return Ip the color of pixel that return by light reflection and Phong reflection model
     */
    private Color calcColor(GeoPoint p) {
        Color color = _scene.get_AmbientLight().get_intensity(); // Ka * Ia
        color = color.add(p.getGeometry().get_emission()); //  + Ie
        Vector v = p.point.subtract(_scene.get_Camera().getP0()).normalize();
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
     * adding color to image by the light sources.
     *
     * @param gp         geo
     * @param result
     * @param k
     * @param v
     * @param n
     * @param nv
     * @param nShininess
     * @param kd
     * @param ks
     * @return
     */
    private Color calcColorByLightSources(GeoPoint gp, Color result, double k, Vector v, Vector n, double nv, int nShininess, double kd, double ks) {
        if (_scene.get_lights() != null) {
            for (LightSource lightS : _scene.get_lights()) {
                Vector l = lightS.getL(gp.point);
                double nl = alignZero(n.dotProduct(l));
                if (nl * nv > 0) {
                    double kTr = transparency(lightS, l, n, gp);
                    if (kTr * k > MIN_CALC_COLOR_K) {
                        Color ip = lightS.getIntensity(gp.point).scale(kTr);
                        result = result.add(
                                calcDiffusive(kd, nl, ip),
                                calcSpecular(ks, l, n, nl, v, nShininess, ip));
                    }
                }
            }
        }
        return result;
    }

    /**
     * find the closet geometry to the ray.
     *
     * @param ray ray reflected or refracted from geometry object. created by constructRefRay
     * @return GeoPoint most closest to ray
     */
    private GeoPoint findClosestIntersection(Ray ray) {
        if (ray == null)
            return null;
        GeoPoint closestPoint = null;
        double closestDistance = Double.MAX_VALUE;
        Point3D rayP = ray.getP0();

        List<GeoPoint> intersections = _scene.get_geometries().findIntersections(ray);
        if (intersections == null)
            return null;
        for (GeoPoint gp : intersections) {
            double distance = rayP.distance(gp.getPoint());
            if (distance < closestDistance) {
                closestPoint = gp;
                closestDistance = distance;
            }
        }
        return closestPoint;
    }


    private Color calcColor(GeoPoint gp, Ray ray) {
        return calcColor(gp, ray, MAX_CALC_COLOR_LEVEL, 1.0).add(_scene.get_AmbientLight().get_intensity());
    }

    private Color calcColor(GeoPoint geoPoint, Ray inRay, int level, double k) {
        Color color = geoPoint.geometry.get_emission();
        Vector n = geoPoint.getGeometry().getNormal(geoPoint.getPoint());
        Vector v = geoPoint.getPoint().subtract(_scene.get_Camera().getP0()).normalize();
        double nv = alignZero(n.dotProduct(v));
        if (nv == 0)
            return color;
        color = color.add(calcColorByLightSources(geoPoint, color, k, v, n, nv, geoPoint.getGeometry().get_material().get_nShininess(), geoPoint.geometry.get_material().get_kD(), geoPoint.getGeometry().get_material().get_kS()));
        if (level == 1 || k < MIN_CALC_COLOR_K) return Color.BLACK; // stop condition

        double kr = geoPoint.geometry.get_material().get_kR(), kkr = k * kr;
        if (kkr > MIN_CALC_COLOR_K) {
            Ray reflectedRay = constructReflectedRay(inRay, geoPoint.getPoint(), n);
            GeoPoint reflectedPoint = findClosestIntersection(reflectedRay);
            if (reflectedPoint != null)
                color = color.add(calcColor(reflectedPoint, reflectedRay, level - 1, kkr).scale(kr));

        }

        double kt = geoPoint.geometry.get_material().get_kT(), kkt = k * kt;
        if (kkt > MIN_CALC_COLOR_K) {
            Ray refractedRay = constructRefractedRay(geoPoint.getPoint(), inRay, n);
            GeoPoint refractedPoint = findClosestIntersection(refractedRay);
            if (refractedPoint != null)
                color = color.add(calcColor(refractedPoint, refractedRay, level - 1, kkt).scale(kt));

        }
        return color;
    }

    /**
     * calculate the transparency cause the shadowing mach depended on the refraction level.
     *
     * @param lightS for light source.
     * @param l      direction of light toward point
     * @param n      normal at Ray end point
     * @param gp     geometry at Ray end point
     * @return transparency between 1 to zero its the level of shadow or refraction.
     */
    private double transparency(LightSource lightS, Vector l, Vector n, GeoPoint gp) {
        Vector lightDirection = l.scale(-1); // from point to light source
        Ray lightRay = new Ray(gp.getPoint(), lightDirection, n);
        List<GeoPoint> intersections = _scene.get_geometries().findIntersections(lightRay);
        if (intersections == null) {
            return 1d;
        }
        double lightDistance = lightS.getDistance(gp.getPoint());
        double ktr = 1d;
        for (GeoPoint geoPoint : intersections) {
            if (alignZero(geoPoint.getPoint().distance(gp.getPoint()) - lightDistance) <= 0) {
                ktr *= geoPoint.getGeometry().get_material().get_kT();
                if (ktr < MIN_CALC_COLOR_K)
                    return 0.0;
            }
        }
        return ktr;
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
        Point3D p0 = _scene.get_Camera().getP0();
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
