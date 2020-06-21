package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource {
    private final Vector _direction;

    public DirectionalLight(Color intensity, Vector direction) {

        this._intensity = intensity;
        this._direction = direction.normalized();
    }

    public Vector get_direction() {
        return _direction;
    }

    @Override
    public Color getIntensity(Point3D point) {
        return super.get_intensity();
    }

    @Override
    public Vector getL(Point3D point) {
        return get_direction();
    }
}
