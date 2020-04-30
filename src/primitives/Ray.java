package primitives;

import static primitives.Util.isZero;

/**
 *
 */
public class Ray {
    Point3D p0;
    Vector dir;

    /**
     * Ctor of A Ray
     * Gets a point 3D and THe vector that the point start the Ray from
     *
     * @param po  point of ray
     * @param vec vector of ray
     */
    public Ray(Point3D po, Vector vec) {
        this.p0 = new Point3D(po);
        this.dir = new Vector(vec.normalize());
    }

    /**
     * @return Vector of direction
     */
    public Vector getDir() {
        return new Vector(dir);
    }

    /**
     * @return Point at the head of the ray
     */
    public Point3D getP0() {
        return new Point3D(p0);
    }

    /**
     * @param t = length of ray from head
     * @return point on ray
     */
    public Point3D getPointOnRay(double t) {
        return isZero(t) ? getP0() : new Point3D(getP0()).add(getDir().scale(t));
    }


    /**
     * Checks two instance of Ray if their properties are equal
     *
     * @param obj
     * @return A boolian veraible
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Ray)) return false;
        Ray oth = (Ray) obj;
        return p0.equals(oth.p0) && dir.equals(oth.dir);
    }
}