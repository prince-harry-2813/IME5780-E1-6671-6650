package primitives;

public class Ray {
    Point3D p0;
    Vector dir;

    public Ray(Point3D po, Vector vec) {
        this.p0 = new Point3D(po);
        this.dir = new Vector(vec.normalize());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Ray)) return false;
        Ray oth = (Ray) obj;
        return p0.equals(oth.p0) && dir.equals(oth.dir);
    }
}