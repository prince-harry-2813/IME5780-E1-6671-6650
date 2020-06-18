package geometries;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * interface that serve all geometry abstract and complex shapes
 */
public abstract class Geometry implements Intersectable {
    protected Color _emission;

    /**
     * Ctor that accept color for emission
     *
     * @param emission Color
     */
    public Geometry(Color emission) {
        this._emission = emission;
    }

    /**
     * default Ctor
     * initialize emission to black(0,0,0).
     */
    public Geometry() {
        this._emission = Color.BLACK;
    }

    /**
     * get point on R3 plane and calculate the normal
     *
     * @param point to extract out normal vector
     * @return Normal vector
     */
    public abstract Vector getNormal(Point3D point);

    /**
     * getter
     *
     * @return emission color
     */
    public Color get_emission() {
        return _emission;
    }
}
