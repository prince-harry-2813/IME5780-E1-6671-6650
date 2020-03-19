package geometries;

public abstract class RadialGeometry implements Geometry
{
    double _radius;
    RadialGeometry(double radius)
    {this._radius=radius;}

    public double get_radius() {
        return _radius;
    }

    @Override
    public String toString() {
        return "RadialGeometry{" +
                "radius=" + _radius +
                '}';
    }
}
