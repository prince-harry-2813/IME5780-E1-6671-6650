package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

import static primitives.Util.alignZero;

public class SpotLight extends PointLight {
    private final Vector _direction;
    double _concentration;

    public SpotLight(Color intensity, Point3D position, Vector direction, double kC, double kL, double kQ) {
        super(intensity, position, kC, kL, kQ);
        this._direction = direction.normalized();
    }

    @Override
    public Color getIntensity(Point3D point) {
        Vector l = getL(point);
        if (l == null) ;
        l = _direction;
        double cos = alignZero(l.dotProduct(_direction));
        if (cos <= 0) return Color.BLACK;
        return super.getIntensity(point).scale(cos);
    }

    public Vector get_direction() {
        return _direction;
    }
}
