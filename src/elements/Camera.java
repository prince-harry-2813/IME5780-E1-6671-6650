package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static primitives.Util.isZero;

public class Camera {
    Point3D p0;
    Vector vUp;
    Vector vTo;
    Vector vRight;
    private static final Random random = new Random();
    /**
     * Ctor
     *
     * @param o  point 3D locate the head of all orientation camera vectors
     * @param up vUp
     * @param to vTo
     */
    public Camera(Point3D o, Vector to, Vector up) {
        if (up.dotProduct(to) != 0)
            throw new IllegalArgumentException("Vector not orthogonal. dot product must return 0");
        p0 = new Point3D(o);
        vUp = up.normalized();
        vTo = to.normalized();
        vRight = (this.vTo.crossProduct(this.vUp)).normalized();
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
     * @return vector orthogonal to vTo &amp; vRight
     */
    public Vector getvUp() {
        return vUp;
    }

    /**
     * @param nX             pixels per W
     * @param nY             pixels per H
     * @param j              location of ray trough pixel
     * @param i              location of ray trough pixel
     * @param screenDistance distance between camera to view plane
     * @param screenWidth    screen width size
     * @param screenHeight   screen height size
     * @return specific Ray from camera toward view plane
     */
    public Ray constructRayThroughPixel(int nX, int nY, int j, int i, double screenDistance, double screenWidth, double screenHeight) {

        if (isZero(screenDistance))
            throw new IllegalArgumentException("distance is zero");
        Point3D pC = p0.add(vTo.scale(screenDistance));
        double ry = screenHeight / nY, rx = screenWidth / nX, yi = ((i - nY / 2d) * ry + ry / 2d), xj = ((j - nX / 2d) * rx + rx / 2d);
        Point3D pij = pC;
        if (!isZero(xj))
            pij = pij.add(vRight.scale(xj));
        if (!isZero(yi))
            pij = pij.subtract(vUp.scale(yi));
        Vector vij = pij.subtract(p0);
        return new Ray(p0, vij);

    }

    /**
     * @param nX             pixels per W
     * @param nY             pixels per H
     * @param j              index location of ray trough pixel
     * @param i              index location of ray trough pixel
     * @param screenDistance distance between camera to view plane
     * @param screenWidth    screen width size
     * @param screenHeight   screen height size
     * @param compactness
     * @param rays
     * @return list of rays from camera to pixel Through view plane
     */
    public List<Ray> constructBeamThroughPixel(int nX, int nY, int j, int i, double screenDistance, double screenWidth, double screenHeight, double compactness, int rays) {

        if (isZero(screenDistance))
            throw new IllegalArgumentException("distance is zero");
        List<Ray> rayList = new LinkedList<>();
        Point3D pxCntr = p0.add(vTo.scale(screenDistance));
        double ry = screenHeight / nY, rx = screenWidth / nX, yi = ((i - nY / 2d) * ry + ry / 2d), xj = ((j - nX / 2d) * rx + rx / 2d);
        Point3D pij = pxCntr;
        if (!isZero(xj))
            pij = pij.add(vRight.scale(xj));
        if (!isZero(yi))
            pij = pij.subtract(vUp.scale(yi));
        double index = Math.sqrt(rays);
        for (int row = 0; row < index; row++) {
            for (int column = 0; column < index; column++) {
                Point3D point3D = new Point3D(pij);
                if (!isZero(row))
                    point3D = point3D.add(vRight.scale((0.1 + random.nextDouble()) * compactness * (row * rx) / index));
                if (!isZero(column))
                    point3D = point3D.add(vUp.scale((compactness * ((0.1 + random.nextDouble()) * column * ry) / index)));
                rayList.add(new Ray(p0, point3D.subtract(p0)));
            }

        }
        return rayList;

    }

}
