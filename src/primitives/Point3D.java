package primitives;

/**
 * this class represent point in R3 dimension.
 * the class hold 3 instance of coord to describe a point.
 *
 * @author yossef steinmetz & arie rosental
 */
public class Point3D {

    public Coordinate x;
    public Coordinate y;
    public Coordinate z;
    /**
     * instance of origin point
     */
   public static final Point3D ZERO = new Point3D(0,0,0);
    /**
     * ctor that gets three Coordinates
     * @param x
     * @param y
     * @param z
     */
    public Point3D(Coordinate x , Coordinate y , Coordinate z){
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
        this.z = new Coordinate(z);
    }

    /**
     * ctor that get three values params
     * @param x
     * @param y
     * @param z
     */
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
        this.x = new Coordinate(other.x.get());
        this.y = new Coordinate(other.y.get());
        this.z = new Coordinate(other.z.get());
    }

    /**
     * point3D getter
     * @return coord value of plane x
     */
    public double getX() {
        return x.get();
    }
    /**
     * point3D getter
     * @return coord value of plane y
     */
    public double getY() {
        return y.get();
    }
    /**
     * point3D getter
     * @return coord value of plane Z
     */
    public double getZ() {
        return z.get();
    }

    public Vector subtract(Point3D sub) {
        return new Vector(sub.x.get() - this.x.get(), sub.y.get() - this.y.get(), sub.z.get() - this.z.get());
    }

    public double distanceSquared(Point3D other) {
        Vector ourVector = this.subtract(other);
        double d = Math.sqrt((ourVector.head.getX() * ourVector.head.getX()) + (ourVector.head.getY() * ourVector.head.getY()) + (ourVector.head.getZ() * ourVector.head.getZ()));
        return d * d;
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

    @Override
    public boolean equals (Object obj)
    {
        if (this== obj) return true;
        if (obj==null) return false;
        if (!(obj instanceof Point3D)) return false;
        Point3D other = (Point3D) obj;
        return x.equals(other.x) && y.equals(other.y) && z.equals(other.z);
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}