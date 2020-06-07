package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.isZero;

/**
 * represent the 3D shape of tube.
 */

public class Tube extends RadialGeometry {

    protected final Ray axisRay;

    /**
     * Ctor uses Ray stor and assigning it into Ray
     *
     * @param radius of tube
     * @param point  of tube
     * @param vec    direction of tube
     */
    public Tube(double radius, Point3D point, Vector vec) {
        super(radius);
        axisRay = new Ray(point, vec);
    }

    public Tube(double radius, Ray axisRy) {
        super(radius);
        this.axisRay = axisRy;
    }

    /**
     * gets a vector and point 3D and normalizing it
     *
     * @param poi to extract a normal vector
     * @return New instance of the normal vector
     */
    @Override
    public Vector getNormal(Point3D poi) {
        Point3D O = this.axisRay.getP0();
        double t = poi.subtract(this.axisRay.getP0()).dotProduct(this.axisRay.getDir());
        if (!isZero(t)) {
            O = this.axisRay.getP0().add(this.axisRay.getDir().scale(t));
        }
        return (poi.subtract(O).normalized());

    }

    @Override
    public String toString() {
        return "Tube{" +
                "axisRay=" + axisRay +
                "} " + super.toString();
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }
}
