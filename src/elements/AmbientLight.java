package elements;

import primitives.Color;

public class AmbientLight {
    Color _intensity;

    public AmbientLight(Color ia, double ka) {
    }

    public Color get_intensity() {
        return _intensity;
    }
}
