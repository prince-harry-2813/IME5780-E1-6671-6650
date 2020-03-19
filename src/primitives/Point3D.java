package primitives;

public class Point3D {


    public Coordinate x;
    public Coordinate y;
    public Coordinate z;

    Point3D ZERO = new Point3D(0,0,0);
    /**
     * ctor that gets three Coordinates
     * @param x
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

    public double getX() {
        return x.get();
    }

    public double getY() {
        return y.get();
    }

    public double getZ() {
        return z.get();
    }

    public Vector Subtract(Point3D sub)
    {
        return new Vector(sub.x.get()-this.x.get(),sub.y.get()-this.y.get(),sub.z.get()-this.z.get());
    }
    public double distanceSquared (Point3D other)
    {
        Vector ourVector = this.Subtract(other);
        double d = Math.sqrt((ourVector.head.getX()*ourVector.head.getX())+(ourVector.head.getY()*ourVector.head.getY())+(ourVector.head.getZ()*ourVector.head.getZ()));
        return d*d;
    }
    public Point3D add (Vector vec)
    {
        return new Point3D(this.getX()+vec.head.getX(),this.getY()+vec.head.getY(),this.getZ()+vec.head.getZ());
    }
    public double distance(Point3D other)
    {
        double d = this.distanceSquared(other);
        return Math.sqrt(d);
    }
}