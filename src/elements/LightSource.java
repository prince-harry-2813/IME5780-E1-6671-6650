package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public interface LightSource {
    Color getIntensity(Point3D point);

    Vector getL(Vector vector);
}
