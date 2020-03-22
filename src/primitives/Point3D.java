package primitives;

/**
 * this class represent point in R3 dimension.
 * the class hold 3 instance of coord to describe a point.
 *
 * @author yossef steinmetz & arie rosental
 */
public class Point3D {

    /**
     * instance of origin point
     */
    public static final Point3D ZERO = new Point3D(0, 0, 0);
    public Coordinate x;
    public Coordinate y;
    public Coordinate z;

    /**
     * ctor that gets three Coordinates
     *
     * @param x
     * @param y
     * @param z
     */
    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
        this.z = new Coordinate(z);
    }

    /**
     * ctor that get three values params
     *
     * @param x
     * @param y
     * @param z
     */
    public Point3D(double x, double y, double z) {
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
        this.z = new Coordinate(z);
    }

    /**
     * Copy ctor
     *
     * @param other
     */
    public Point3D(Point3D other) {
        this.x = new Coordinate(other.x.get());
        this.y = new Coordinate(other.y.get());
        this.z = new Coordinate(other.z.get());
    }

    /**
     * point3D getter
     *
     * @return coord value of plane x
     */
    public double getX() {
        return x.get();
    }

    /**
     * point3D getter
     *
     * @return coord value of plane y
     */
    public double getY() {
        return y.get();
    }

    /**
     * point3D getter
     *
     * @return coord value of plane Z
     */
    public double getZ() {
        return z.get();
    }

    public Vector subtract(Point3D sub) {
        return new Vector(sub.x.get() - this.x.get(), sub.y.get() - this.y.get(), sub.z.get() - this.z.get());
    }

    /**
     * calculate the distance between tow points
     *
     * @param other
     * @return double number that represent the distance
     */
    public double distanceSquared(Point3D other) {
        Vector ourVector = this.subtract(other);
        double d = Math.sqrt((ourVector.head.getX() * ourVector.head.getX()) + (ourVector.head.getY() * ourVector.head.getY()) + (ourVector.head.getZ() * ourVector.head.getZ()));
        return d * d;
    }

    /**
     * Adding point to a Vector
     * @param vec
     * @return new instance of point 3D of the head of the vector
     */
    public Point3D add(Vector vec) {
        return new Point3D(this.getX() + vec.head.getX(), this.getY() + vec.head.getY(), this.getZ() + vec.head.getZ());
    }

    /**
     * Calculates the squered distance of a vector from its normal.
     * @param other
     * @return A double number
     */
    public double distance(Point3D other) {
        double d = this.distanceSquared(other);
        return Math.sqrt(d);
    }

    /**
     * Checks two point if their properties are equal
     * @param obj
     * @return A boolian varaible
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Point3D)) return false;
        Point3D other = (Point3D) obj;
        return x.equals(other.x) && y.equals(other.y) && z.equals(other.z);
    }

    /**
     *  Override Coordinates function
     * @return To string of a Point 3D
     */
    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}