package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Sphere extends RadialGeometry {



    public Sphere(double radius) {
        super(radius);
    }

    @Override
    public Vector getNormal(Point3D point) {
        Vector vec = new Vector(point);
        return vec.normalize();
    }
}
