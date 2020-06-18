package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource {
    private Vector _direction;

    public DirectionalLight(Color intensity) {
        super(intensity);
    }

    public Vector get_direction() {
        return _direction;
    }

    @Override
    public Color getIntensity(Point3D point) {
        return null;
    }

    @Override
    public Vector getL(Vector vector) {
        return null;
    }
}
