package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
/**
 * represent the 3D shape of tube.
 */

public class Tube extends RadialGeometry {

    Ray axisRay;

    /**
     * Ctor uses Ray stor and assigning it into Ray
     * @param radius
     * @param point
     * @param vec
     */
    public Tube(double radius, Point3D point, Vector vec) {
        super(radius);
        axisRay = new Ray(point, vec);
    }

    /**
     * gets a vector and point 3D and normalizing it
     * @param point
     * @return New instance of the normal vector
     */
    @Override
    public Vector getNormal(Point3D point) {
        Vector vec = new Vector(point);
        return vec.normalize();
    }

    @Override
    public String toString() {
        return "Tube{" +
                "axisRay=" + axisRay +
                "} " + super.toString();
    }
}
