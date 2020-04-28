package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Plane {

    Point3D p;
    Vector normal;

    public Plane(Point3D point, Vector vec) {
        p = new Point3D(point);
        normal = new Vector(vec.normalize());
    }

    public Plane(Point3D a, Point3D b, Point3D c) {
        p = new Point3D(a);
        Vector v1 = p.subtract(b);
        Vector v2 = p.subtract(c);
        normal = (v1.crossProduct(v2).normalize());
    }

    public Vector getNormal() {
        return normal;
    }
}
