package primitives;

public class Ray {
    Point3D p0;
    Vector dir;

    public Ray(Point3D po, Vector vec) {
        this.p0 = new Point3D(po);
        this.dir = new Vector(vec);
        this.dir.normalize();
    }
}