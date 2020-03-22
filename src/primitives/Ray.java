package primitives;

/**
 *
 */
public class Ray {
    Point3D p0;
    Vector dir;

    /**
     * Ctor of A Ray
     * Gets a point 3D and THe vector that the point start the Ray from
     * @param po
     * @param vec
     */
    public Ray(Point3D po, Vector vec) {
        this.p0 = new Point3D(po);
        this.dir = new Vector(vec.normalize());
    }

    /**
     * Checks two instance of Ray if their properties are equal
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