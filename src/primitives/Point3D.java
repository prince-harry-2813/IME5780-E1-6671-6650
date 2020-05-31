package primitives;

/**
 * this class represent point in R3 dimension.
 * the class hold 3 instance of coord to describe a point.
 *
 * @author yossef steinmetz and arie rosental
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
     * @param x coord x
     * @param y coord y
     * @param z coord z
     */
    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
        this.z = new Coordinate(z);
    }

    /**
     * ctor that get three values params
     *
     * @param x coord x
     * @param y coord y
     * @param z coord z
     */
    public Point3D(double x, double y, double z) {
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
        this.z = new Coordinate(z);
    }

    /**
     * Copy ctor
     *
     * @param other copied obj point_3D
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
    public Coordinate getX() {
        return x;
    }


    /**
     * point3D getter
     *
     * @return coord value of plane y
     */
    public Coordinate getY() {
        return y;
    }


    /**
     * point3D getter
     *
     * @return coord value of plane Z
     */

    public Coordinate getZ() {
        return z;
    }

    /**
     * @param sub vector to subtracting from original point
     * @return Point that accept by subtract vector from point (this - sub)
     */
    public Point3D subtract(Vector sub) {
        return new Point3D(this.x.get() - sub.head.x.get(), this.y.get() - sub.head.y.get(), this.z.get() - sub.head.z.get());
    }

    /**
     * @param sub point that subtract the original point (sub - this)
     * @return vector between tow points
     */
    public Vector subtract(Point3D sub) {
        return new Vector(this.x.get() - sub.x.get(), this.y.get() - sub.y.get(), this.z.get() - sub.z.get());
    }

    /**
     * calculate the distance between tow points
     *
     * @param other the second point.
     * @return double number that represent the distance
     */
    public double distanceSquared(Point3D other) {
        Vector ourVector = this.subtract(other);
        double d = Math.sqrt((ourVector.head.getX().get() * ourVector.head.getX().get()) + (ourVector.head.getY().get() * ourVector.head.getY().get()) + (ourVector.head.getZ().get() * ourVector.head.getZ().get()));
        return d * d;
    }

    /**
     * Adding point to a Vector
     *
     * @param vec vector to add
     * @return new instance of point 3D of the head of the vector
     */
    public Point3D add(Vector vec) {
        return new Point3D(this.getX().get() + vec.head.getX().get(), this.getY().get() + vec.head.getY().get(), this.getZ().get() + vec.head.getZ().get());
    }

    /**
     * Calculates the squered distance of a vector from its normal.
     * @param other the second point
     * @return A double number
     */
    public double distance(Point3D other) {
        double d = this.distanceSquared(other);
        return Math.sqrt(d);
    }

    /**
     * Checks two point if their properties are equal
     * @param obj the obj that we compere to
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
        return "(" + "x=" + x + ", y=" + y + ", z=" + z + ')';
    }
}