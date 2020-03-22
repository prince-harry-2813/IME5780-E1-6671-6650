package geometries;

public abstract class RadialGeometry implements Geometry {
    double _radius;

    /**
     * ctor to all abstract circle object. accept one param that is the radius
     *
     * @param radius
     */
    public RadialGeometry(double radius) {
        this._radius = radius;
    }

    /**
     * getter
     *
     * @return the redius
     */
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
