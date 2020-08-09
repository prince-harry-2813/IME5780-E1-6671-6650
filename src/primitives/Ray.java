package primitives;

import static primitives.Util.isZero;

/**
 *
 */
public class Ray {
    Point3D p0;
    Vector dir;
    private static final double DELTA = 0.1;

    /**
     * ctor of secondary Ray: the head = p0 + normal.scale(DELTA * sign)
     * @param p0 head of the ray
     * @param direction direction of the ray
     * @param normal normal to ray end point
     */
    public Ray(Point3D p0, Vector direction, Vector normal) {
        dir = new Vector(direction).normalized();
        double nv = normal.dotProduct(direction);
        Vector delta = normal.scale(nv > 0 ? DELTA : -DELTA);//according to the sign of Normal DP Direction
        this.p0 = p0.add(delta);
    }

    /**
     * Ctor of A Ray
     * Gets a point 3D and THe vector that the point start the Ray from
     *
     * @param po  point of ray
     * @param vec vector of ray
     */
    public Ray(Point3D po, Vector vec) {
        this.p0 = new Point3D(po);
        this.dir = new Vector(vec.normalized());
    }

    /**
     * copy Ctor
     * @param oth other Ray
     */
    public Ray(Ray oth) {
        this(oth.getP0(), oth.getDir());
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
     * @param obj other object to compere
     * @return A boolean variable
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Ray))
            return false;
        if (this == obj)
            return true;
        Ray oth = (Ray) obj;
        return p0.equals(oth.p0) && dir.equals(oth.dir);
    }

    @Override
    public String toString() {
        return "Ray{" +
                "p0=" + p0 +
                ", dir=" + dir +
                '}';
    }
}