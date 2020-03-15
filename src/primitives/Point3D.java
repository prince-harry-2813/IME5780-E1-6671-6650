package primitives;

public class Point3D {


    public Coordinate x;
    public Coordinate y;
    public Coordinate z;

    Point3D ZERO = new Point3D(0,0,0);
    /**
     * ctor that gets three Coordinates
     * @param
     * @param y
     * @param z
     */
    public Point3D(Coordinate x , Coordinate y , Coordinate z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D(double x , double y, double z){
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
        this.z = new Coordinate(z);
    }

    /**
     * Copy ctor
     * @param other
     */
    public Point3D(Point3D other){
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
    }

    public Coordinate getX() {
        return x;
    }

    public Coordinate getY() {
        return y;
    }

    public Coordinate getZ() {
        return z;
    }

    public Vector Subtract(Point3D sub)
    {
    }

}