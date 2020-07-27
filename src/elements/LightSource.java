package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public interface LightSource {
    Color getIntensity(Point3D point);

    double getDistance(Point3D geoPoint);

    Vector getL(Point3D point);
}
