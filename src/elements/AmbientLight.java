package elements;

import primitives.Color;

public class AmbientLight extends Light {


    /**
     * Ctor for ambient light
     *
     * @param ia intensity
     * @param ka scale param
     */
    public AmbientLight(Color ia, double ka) {
        this._intensity = ia.scale(ka);
    }

    /**
     * ctor for ambient light that return the intensity multiply by 1
     *
     * @param ia intensity color
     */
    public AmbientLight(Color ia) {
        this(ia, 1d);
    }


}
