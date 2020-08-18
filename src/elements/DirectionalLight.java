package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource {
    private final Vector _direction;

    public DirectionalLight(Color intensity, Vector direction) {

        super(intensity);
        this._direction = direction.normalized();
    }

    public Vector get_direction() {
        return this._direction;
    }

    @Override
    public Color getIntensity(Point3D point) {
        return this._intensity;
    }

    @Override
    public double getDistance(Point3D geoPoint) {
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public Vector getL(Point3D point) {
        return get_direction();
    }
}
