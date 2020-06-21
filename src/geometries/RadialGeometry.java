package geometries;

import primitives.Color;
import primitives.Material;

import static primitives.Util.isZero;

public abstract class RadialGeometry extends Geometry {
    double _radius;

    /**
     * ctor to all abstract circled object. accept one param that is the radius
     *
     * @param radius of shape
     */
    public RadialGeometry(double radius) {
        super();//define emission and material to default values
        if (isZero(radius) || radius < 0d)
            throw new IllegalArgumentException("radius is: " + radius + ", it can't be negative");
        this._radius = radius;
    }

    /**
     * ctor to all abstract circled object. accept radius and emission color
     *
     * @param emission color
     * @param radius   length
     */
    public RadialGeometry(Color emission, double radius) {
        super(emission); //define emission color and Material to default value
        if (isZero(radius) || radius < 0d)
            throw new IllegalArgumentException("radius is: " + radius + ", it can't be negative");
        this._radius = radius;

    }

    public RadialGeometry(Color emission, Material material, double radius) {
        super(emission, material); //define emission color and Material by father ctor
        if (isZero(radius) || radius < 0d)
            throw new IllegalArgumentException("radius is: " + radius + ", it can't be negative");
        this._radius = radius;

    }

    /**
     * copy ctor
     *
     * @param other RadialGeometry
     */
    public RadialGeometry(RadialGeometry other) {
        super(other.get_emission(), other.get_material()); //define emission color
        this._radius = other.get_radius();
    }

    /**
     * getter
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
