package primitives;

public class Material {
    double _kD, _kS, _kT, _kR;
    int _nShininess;

    /**
     * ctor
     *
     * @param kd         diffusive factor component
     * @param ks         specular factor component
     * @param nShininess shininess factor component
     */
    public Material(double kd, double ks, int nShininess) {
        this._kD = kd;
        this._kS = ks;
        this._nShininess = nShininess;
    }

    /**
     * ctor
     *
     * @param kd         diffusive factor component
     * @param ks         specular factor component
     * @param nShininess shininess factor component
     * @param kt         transparency factor component
     * @param kr         reflection factor component
     */
    public Material(double kd, double ks, int nShininess, double kt, double kr) {
        this(kd, ks, nShininess);
        this._kT = kt;
        this._kR = kr;
        this._kS = ks;
    }

    /**
     * copy ctor
     *
     * @param material object to copy from
     */
    public Material(Material material) {
        this(material._kD, material._kS, material._nShininess);
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
        return _kS;
    }

    /**
     * getter
     *
     * @return specular factor component
     */
    public double get_kR() {
        return _kR;
    }

    /**
     * getter
     *
     * @return transparency factor component
     */
    public double get_kT() {
        return _kT;
    }

}
