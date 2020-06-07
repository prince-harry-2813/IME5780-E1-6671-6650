package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

public class Plane implements Geometry {

    Point3D p;
    Vector normal;

    /**
     * ctor of plane by point and vector
     *
     * @param point Point3D
     * @param vec   Vector of plane
     */
    public Plane(Point3D point, Vector vec) {
        p = new Point3D(point);
        normal = new Vector(vec.normalize());
    }

    /**
     * ctor of plane by three points, calculate the plane normal
     *
     * @param a Point3D A
     * @param b Point3D B
     * @param c Point3D C
     */
    public Plane(Point3D a, Point3D b, Point3D c) {
        p = new Point3D(a);
        Vector v1 = b.subtract(p);
        Vector v2 = c.subtract(p);
        normal = (v1.crossProduct(v2).normalize());
    }

    /**
     * @return Normal
     */
    public Vector getNormal() {
        return normal;
    }

    /**
     * @param point to extract out normal vector
     * @return Normal
     */
    @Override
    public Vector getNormal(Point3D point) {
        return normal;
    }

    /**
     * @param ray A ray that light on an the plane
     * @return list of intersection points
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        Vector p_0;
        try {
            p_0 = p.subtract(ray.getP0());
        } catch (IllegalArgumentException e) {
            return null;
        }

        double nv = alignZero(getNormal().dotProduct(ray.getDir()));
        if (isZero(nv))
            return null;
        double t = alignZero((getNormal().dotProduct(p.subtract(ray.getP0()))) / (nv));

        if (t <= 0)
            return null;
        return List.of(ray.getPointOnRay(t));
    }
}
