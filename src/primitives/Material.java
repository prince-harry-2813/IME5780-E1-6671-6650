package primitives;

public class Material {
    double _kD, kS;
    int _nShininess;

    /**
     * @param kd
     * @param ks
     * @param nShininess
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

    public int get_nShininess() {
        return _nShininess;
    }

    public double get_kD() {
        return _kD;
    }

    public double getkS() {
        return kS;
    }
}
