package elements;

import primitives.Color;

public class AmbientLight extends Light {


    /**
     * Ctor for ambient light
     *
     * @param ia
     * @param ka
     */
    public AmbientLight(Color ia, double ka) {
        super(ia.scale(ka));
    }

    /**
     * ctor for ambient light that return the intensity multiply by 1
     *
     * @param ia color
     */
    public AmbientLight(Color ia) {
        this(ia, 1d);
    }


}
