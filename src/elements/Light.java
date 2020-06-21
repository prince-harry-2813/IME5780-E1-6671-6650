package elements;

import primitives.Color;

/**
 * class for light object
 */
abstract class Light {
    protected Color _intensity;
    /**
     * getter
     * @return color of intensity.
     */
    public Color get_intensity() {
        return _intensity;
    }
}
