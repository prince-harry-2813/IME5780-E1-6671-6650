package primitives;

public class Vector {
    Point3D head;
    Vector (Point3D in) throws IllegalArgumentException
    {
        this.head.x = new Coordinate(in.x.get());
        this.head.y = new Coordinate(in.y.get());
        this.head.z = new Coordinate(in.z.get());
        if (head.equals (Point3D.ZERO)) throw new IllegalArgumentException ("all arguments are zero");
    }
    Vector(Coordinate x, Coordinate y, Coordinate z) throws IllegalArgumentException
    {
        this.head.x = x;
        this.head.y = y;
        this.head.z = z;
        if (head.equals (Point3D.ZERO)) throw new IllegalArgumentException ("all arguments are zero");
    }
    Vector (double x, double y, double z) throws IllegalArgumentException
    {
        this.head.x = new Coordinate(x);
        this.head.y = new Coordinate(y);
        this.head.z = new Coordinate(z);
        if (head.equals (Point3D.ZERO)) throw new IllegalArgumentException ("all arguments are zero");
    }
    Vector (Vector other)
    {
        this.head.x = new Coordinate( other.head.getX());
        this.head.y = new Coordinate( other.head.getY());
        this.head.z = new Coordinate( other.head.getZ());
    }
    public boolean equals (Object obj)
    {
        if (this== obj) return true;
        if (obj==null) return false;
        if (!(obj instanceof Vector)) return false;
        Vector other = (Vector) obj;
        return head.equals(other);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "head=" + head +
                '}';
    }
}
