package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

public class Cylinder extends Tube {
    double height;

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

    public Cylinder(double radius, double h, Ray axis) {
        super(radius, axis);
        this.height = h;
    }

    @Override
    public Vector getNormal(Point3D point) {

        double t = alignZero(this.axisRay.getP0().subtract(point).dotProduct(this.axisRay.getDir()));
        if (t == 0 || isZero(this.height - t))
            return axisRay.getDir().normalize();
        Point3D o = axisRay.getP0().add(axisRay.getDir().scale(t));
        return o.subtract(point).normalize();
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                ", axisRay=" + axisRay +
                ", _radius=" + _radius +
                "} " + super.toString();
    }
}
