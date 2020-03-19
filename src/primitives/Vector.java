package primitives;

public class Vector {
    Point3D head;
    Vector (Point3D in)
    {
        this.head.x=in.x;
        this.head.y=in.y;
        this.head.z=in.z;
    }
    Vector (double x, double y, double z)
    {
        this.head.x= new Coordinate(x);
        this.head.y= new Coordinate(y);
        this.head.z= new Coordinate(z);
    }
    Vector (Vector other)
    {
        this.head.x=other.head.x;
        this.head.y= other.head.y;
        this.head.z= other.head.z;
    }
}
