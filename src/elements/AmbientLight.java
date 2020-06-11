package elements;

import primitives.Color;

public class AmbientLight {
    Color _intensity;

    /**
     * Ctor for ambient light
     *
     * @param ia
     * @param ka
     */
    public AmbientLight(Color ia, double ka) {
        this._intensity = ia.scale(ka);
    }

    /**
     * ctor for ambient light that return the intensity multiply by 1
     *
     * @param ia color
     */
    public AmbientLight(Color ia) {
        this(ia, 1d);
    }

    /**
     * getter
     *
     * @return intensity of ambient light
     */
    public Color get_intensity() {
        return _intensity;
    }
}
