package geometries;

import primitives.Point3D;
import primitives.Vector;

/**
 * interface that serve all geometry abstract and complex shapes
 */
public interface Geometry {
    /**
     * get point on R3 plane and calculate the normal
     *
     * @param point to extract out normal vector
     * @return normal vector
     */
    Vector getNormal(Point3D point);

}
