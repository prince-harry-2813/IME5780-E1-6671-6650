package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class PointLight extends Light implements LightSource {
    protected Point3D _position;
    protected double _kC, _kL, _kQ;

    public PointLight(Color intensity, Point3D position, double kC, double kL, double kQ) {
        super(intensity);
        this._position = new Point3D(position);
        this._kC = kC;
        this._kL = kL;
        this._kQ = kQ;
    }

    public double get_kC() {
        return _kC;
    }

    public double get_kL() {
        return _kL;
    }

    public double get_kQ() {
        return _kQ;
    }

    public Point3D get_position() {
        return _position;
    }


    @Override
    public Color getIntensity(Point3D point) {
        double distanceSQRD = _position.distanceSquared(point);
        double distance = _position.distance(point);
        return _intensity.reduce(_kC + _kL * distance + _kQ * distanceSQRD);
    }

    @Override
    public Vector getL(Point3D point) {
        try {
            return point.subtract(_position).normalize();
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
