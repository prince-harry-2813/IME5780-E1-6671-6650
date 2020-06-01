package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

public class Cylinder extends Tube {
    double height;

    /**
     * @param radius of cylinder
     * @param h      height of the cylinder
     * @param axis   point & vector of projection ray
     */
    public Cylinder(double radius, double h, Ray axis) {
        super(radius, axis);
        this.height = h;
    }

    /**
     * ctor that based on father ctor, also accept the height to represent the cylinder.
     *
     * @param radius of cylinder
     * @param point  of cylinder
     * @param vec    of cylinder
     * @param h      height
     */
    public Cylinder(double radius, Point3D point, Vector vec, double h) {
        super(radius, point, vec);
        this.height = h;
    }

    /**
     * getter
     *
     * @return the height of th cylinder
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param point
     * @return
     */
    @Override
    public Vector getNormal(Point3D point) {
        double t;
        try {
            t = alignZero(point.subtract(this.axisRay.getP0()).dotProduct(this.axisRay.getDir()));
        } catch (IllegalArgumentException e) {
            return this.axisRay.getDir();
        }
        if (t == 0 || isZero(this.height - t))
            return axisRay.getDir().normalized();
        Point3D o = axisRay.getP0().add(axisRay.getDir().scale(t));
        return (point.subtract(this.axisRay.getP0()).normalized());
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                ", axisRay=" + axisRay +
                ", _radius=" + _radius +
                "} " + super.toString();
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        return super.findIntersections(ray);
    }
}
