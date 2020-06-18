package elements;

import primitives.Color;

/**
 * class for light object
 */
abstract class Light {
    protected Color _intensity;

    public Light(Color intensity) {
        this._intensity = intensity;
    }

    /**
     * getter
     *
     * @return color of intensity.
     */
    public Color get_intensity() {
        return _intensity;
    }
}
