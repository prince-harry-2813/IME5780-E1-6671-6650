package geometries;

import primitives.Point3D;
import primitives.Vector;

public abstract class RadialGeometry
{
    double _radius;
    RadialGeometry(double radius)
    {this._radius=radius;}

    public double get_radius() {
        return _radius;
    }

    public abstract Vector getNormal(Point3D point);

    @Override
    public String toString() {
        return "RadialGeometry{" +
                "radius=" + _radius +
                '}';
    }
}
