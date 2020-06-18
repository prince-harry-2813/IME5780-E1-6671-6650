package elements;

import primitives.Color;
import primitives.Vector;

public class SpotLight extends PointLight {
    private Vector _direction;

    public SpotLight(Color intensity) {
        super(intensity);
    }

    public Vector get_direction() {
        return _direction;
    }
}
