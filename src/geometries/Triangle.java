package geometries;

import primitives.Color;
import primitives.Point3D;

public class Triangle extends Polygon {

    /**
     * Triangle ctor Build it out of 3 point 3D
     *
     * @param a point a
     * @param b point b
     * @param c point c
     */
    public Triangle(Point3D a, Point3D b, Point3D c) {
        super(a, b, c);
    }

    /**
     * Triangle ctor Build it out of 3 point 3D
     *
     * @param emission color
     * @param a        point a
     * @param b        point b
     * @param c        point c
     */
    public Triangle(Color emission, Point3D a, Point3D b, Point3D c) {
        super(emission, a, b, c);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
