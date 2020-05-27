package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;

public class Sphere extends RadialGeometry {

    /**
     * center of sphere
     */
    Point3D center;

    /**
     * ctor
     *
     * @param radius  of the sphere
     * @param _center point of the sphere
     */
    public Sphere(double radius, Point3D _center) {
        super(radius);
        this.center = _center;
    }

    @Override
    public Vector getNormal(Point3D point) {
        Vector vec = new Vector(center.subtract(point));
        return vec.normalized();
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        Vector u;
        try {
            u = ray.getP0().subtract(center);
        } catch (IllegalArgumentException e) // in case that the ray start at the edge of the sphere
        {
            return List.of(ray.getPointOnRay(get_radius()));
        }
        double tm = alignZero(ray.getDir().dotProduct(u));
        double d;
        if (tm == 0)
            d = u.lengthSquared();
        else d = u.lengthSquared() - (tm * tm);
        double thPow = alignZero(get_radius() * get_radius() - d);
        if (thPow <= 0) return null;
        double th = alignZero(Math.sqrt(thPow));
        if (th == 0) return null;
        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);
        if (t1 <= 0 && t2 <= 0) return null;
        if (t1 > 0 && t2 > 0)
            return List.of(ray.getPointOnRay(t1), ray.getPointOnRay(t2));
        return t1 > 0 ? List.of(ray.getPointOnRay(t1)) : List.of(ray.getPointOnRay(t2));

    }
}
