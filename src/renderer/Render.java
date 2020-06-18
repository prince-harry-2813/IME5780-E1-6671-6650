package renderer;

import elements.Camera;
import geometries.Intersectable;
import geometries.Intersectable.GeoPoint;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;

import java.util.List;

public class Render {
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

    /**
     * @param p
     * @return
     */
    private Color calcColor(GeoPoint p) {
        Color color = _scene.get_ambientLight().get_intensity();
        color = color.add(p.getGeometry().get_emission());
        return color;
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
