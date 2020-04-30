package geometries;

import static primitives.Util.isZero;

public abstract class RadialGeometry implements Geometry {
    double _radius;

    /**
     * ctor to all abstract circled object. accept one param that is the radius
     *
     * @param radius of shape
     */
    public RadialGeometry(double radius) {
        if (isZero(radius) || radius < 0.)
            throw new IllegalArgumentException("radius is: " + radius + ", it can't be negative");
        this._radius = radius;
    }

    /**
     * copy ctor
     *
     * @param other RadialGeometry
     */
    public RadialGeometry(RadialGeometry other) {
        this._radius = other.get_radius();
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
        return "{" +
                "radius=" + _radius +
                '}';
    }
}
