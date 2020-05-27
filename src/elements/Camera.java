package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Camera {
    Point3D p0;
    Vector vUp;
    Vector vTo;
    Vector vRight;

    /**
     * Ctor
     *
     * @param o  point 3D locate the head of all orientation camera vectors
     * @param up vUp
     * @param to vTo
     */
    public Camera(Point3D o, Vector up, Vector to) {
        if (to.dotProduct(up) != 0)
            throw new IllegalArgumentException("Vector not orthogonal. dot product must return 0");
        p0 = o;
        vUp = up;
        vTo = to;
        vRight = up.crossProduct(to);
    }

    /**
     * @return point of camera view
     */
    public Point3D getP0() {
        return p0;
    }

    /**
     * @return vector orientation of camera
     */
    public Vector getvRight() {
        return vRight;
    }

    /**
     * @return vector direct forward from camera
     */
    public Vector getvTo() {
        return vTo;
    }

    /**
     * @return vector orthogonal to vTo & vRight
     */
    public Vector getvUp() {
        return vUp;
    }

    public Ray constructRayThroughPixel(int nX, int nY, int j, int i, double screenDistance, double screenWidth, double screenHeight) {

        return null;
    }

}
