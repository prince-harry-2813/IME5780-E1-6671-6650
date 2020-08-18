package geometries;

import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;

/**
 * interface that serve all geometry abstract and complex shapes
 */
public abstract class Geometry implements Intersectable {
    protected Color _emission;
    protected Material _material;

    /**
     * Ctor that accept color for emission, and material params
     *
     * @param emission object.
     * @param material object
     */
    public Geometry(Color emission, Material material) {
        this._emission = emission;
        this._material = material;
    }

    /**
     * Ctor that accept color for emission
     * initialize material to default
     *
     * @param emission Color
     */
    public Geometry(Color emission) {
        this(emission, new Material(0, 0, 0));

    }

    /**
     * default Ctor
     * initialize emission to black(0,0,0).
     */
    public Geometry() {
        this(Color.BLACK);
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

    /**
     * @return material of object
     */
    public Material get_material() {
        return _material;
    }
}
