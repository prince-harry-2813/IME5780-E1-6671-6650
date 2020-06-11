package elements;

import primitives.Color;

public class AmbientLight {
    Color _intensity;

    public AmbientLight(Color ia, double ka) {
        this._intensity = ia.scale(ka);
    }

    public AmbientLight(Color ia) {
        this(ia, 1d);
    }

    public Color get_intensity() {
        return _intensity;
    }
}
