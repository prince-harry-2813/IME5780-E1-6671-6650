package geometries;

import primitives.Point3D;

public class Triangle extends Polygon {

    /**
     * Triangle ctor Biuld it out of 3 point 3D
     *
     * @param a point a
     * @param b point b
     * @param c point c
     */
    public Triangle(Point3D a, Point3D b, Point3D c) {
        super(a, b, c);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
