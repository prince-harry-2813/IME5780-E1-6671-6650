package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

public class Sphere extends RadialGeometry {


    Point3D center;

    public Sphere(double radius, Point3D _center) {
        super(radius);
        this.center = _center;
    }

    @Override
    public Vector getNormal(Point3D point) {
        Vector vec = new Vector(center.subtract(point));
        return vec.normalize();
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }
}
