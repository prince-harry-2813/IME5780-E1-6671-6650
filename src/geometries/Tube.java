package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Tube extends RadialGeometry {

    Ray axisRay;

    public Tube(double radius, Point3D point, Vector vec) {
        super(radius);
        axisRay = new Ray(point, vec);
    }

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
