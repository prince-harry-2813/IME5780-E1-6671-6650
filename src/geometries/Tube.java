package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Tube extends RadialGeometry {

    Tube(double radius) {
        super(radius);
    }

    @Override
    public Vector getNormal(Point3D point) {
        return null;
    }
}
