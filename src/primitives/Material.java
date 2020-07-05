package primitives;

public class Material {
    double _kD, kS;
    int _nShininess;

    /**
     * @param kd         diffusive factor component
     * @param ks         specular factor component
     * @param nShininess shininess factor component
     */
    public Material(double kd, double ks, int nShininess) {
        this._kD = kd;
        this.kS = ks;
        this._nShininess = nShininess;
    }

    /**
     * copy ctor
     *
     * @param material object to copy from
     */
    public Material(Material material) {
        this(material._kD, material.kS, material._nShininess);
    }

    /**
     * getter
     *
     * @return shininess factor component
     */
    public int get_nShininess() {
        return _nShininess;
    }

    /**
     * getter
     *
     * @return diffusive factor component
     */
    public double get_kD() {
        return _kD;
    }

    /**
     * getter
     *
     * @return specular factor component
     */
    public double get_kS() {
        return kS;
    }
}
