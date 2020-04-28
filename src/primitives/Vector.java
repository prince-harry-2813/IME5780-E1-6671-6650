package primitives;

public class Vector {
    Point3D head;

    public Point3D getHead() {
        return head;
    }

    /**
     * Ctor of vector
     * Gets a point 3D
     * And checks if the vector is equal to ZERO then throwing an exception
     *
     * @param in the copied class.
     * @throws IllegalArgumentException
     */
    public Vector(Point3D in) throws IllegalArgumentException {
        this.head = new Point3D(in);
        if (head.equals(Point3D.ZERO)) throw new IllegalArgumentException("all arguments are zero");
    }

    /**
     * Ctor of vector
     * Gets 3 Coordinates and calls to point 3D ctor
     * And checks if the vector is equal to ZERO then throwing an exception
     * @param x
     * @param y
     * @param z
     * @throws IllegalArgumentException
     */
    public Vector(Coordinate x, Coordinate y, Coordinate z) throws IllegalArgumentException {
        this.head = new Point3D(x, y, z);
        if (head.equals(Point3D.ZERO)) throw new IllegalArgumentException("all arguments are zero");
    }

    /**
     * Ctor of vector
     * Gets 3 numbers and calls to point 3D ctor
     * And checks if the vector is equal to ZERO then throwing an exception
     * @param x
     * @param y
     * @param z
     * @throws IllegalArgumentException
     */
    public Vector(double x, double y, double z) throws IllegalArgumentException {
        this.head = new Point3D(x, y, z);
        if (head.equals(Point3D.ZERO)) throw new IllegalArgumentException("all arguments are zero");
    }

    /**
     * Gets a vector and creating new instance of Point 3D
     * @param other
     */
    public Vector(Vector other) {
        this.head = new Point3D(other.head);
    }

    /**
     * Substracts two vectors with Point 3D subtract function
     * @param other
     * @return
     */
    public Vector subtract(Vector other) {
        return (this.head.subtract(other.head));
    }

    /**
     * Adds two vectors Using point 3D add function
     * @param other
     * @return
     */
    public Vector add(Vector other) {
        return new Vector(this.head.add(other));
    }


    /**
     * Multiplies a vector in scalar (double)
     * @param scalar
     * @return New instance of a vector
     */
    public Vector scale(double scalar) {
        return new Vector(scalar * this.head.getX(), scalar * this.head.getY(), scalar * this.head.getZ());
    }

    /**
     * Gets Two vector and multiple it with each other
     * @param other
     * @return Dot product as double
     */
    public double dotProduct(Vector other) {
        return ((this.head.getX() * other.head.getX()) + (this.head.getY() * other.head.getY()) + (this.head.getZ() * other.head.getZ()));
    }

    /**
     * Gets two vectors and multiple each part of them in the other
     * @param oth
     * @return Its dot product ( a new vector that its vertical to the two others
     */
    public Vector crossProduct(Vector oth) {
        return new Vector((this.head.getY() * oth.head.getZ()) - (this.head.getZ() * oth.head.getY())
                , (this.head.getZ() * oth.head.getX()) - (this.head.getX() * oth.head.getZ())
                , (this.head.getX() * oth.head.getY()) - (this.head.getY() * oth.head.getX()));
    }

    /**
     * Multiple the vector in its self
     * @return Positive Squared value of the vector
     */
    public Double lengthSquared() {
        double d = Math.sqrt((head.getX() * head.getX()) + (head.getY() * head.getY()) + (head.getZ() * head.getZ()));
        return d * d;
    }

    /**
     * Uses lengthSquared function
     * @return the length of the vector
     */
    public double length() {
        double l = this.lengthSquared();
        return Math.sqrt(l);
    }

    /**
     * Gets a vector and dividing its point by the length of the vector
     * @return The same vector as normal (vector that is vertical to any vector in the filed
     */
    public Vector normalize() {
        double divider = this.length();
        this.head.x = new Coordinate(head.getX() / divider);
        this.head.y = new Coordinate(head.getY() / divider);
        this.head.z = new Coordinate(head.getZ() / divider);
        return this;
    }

    /**
     * Gets a vector and uses the normal vector
     * @return returns new instance of a vector as normal
     */
    public Vector normalized() {
        Vector vec = new Vector(this);
        vec.normalize();
        return vec;
    }

    /**
     * Ovverride Point 3D to string
     * @param obj
     * @return Vector to string
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Vector)) return false;
        Vector other = (Vector) obj;
        return head.equals(other.head);
    }

    /**
     * print vector as mathematical view
     * @return
     */
    @Override
    public String toString() {
        return "Vector{" +
                "head=" + head +
                '}';
    }
}
