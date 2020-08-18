package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public interface LightSource {

    Color getIntensity(Point3D point);

    /**
     * calculate the distance between light source to object
     *
     * @param geoPoint point on geometry
     * @return distance
     */
    double getDistance(Point3D geoPoint);

    /**
     * get light direction
     *
     * @param point on object
     * @return vector of direction from light toward object point
     */
    Vector getL(Point3D point);
}
