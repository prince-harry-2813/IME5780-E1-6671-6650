package scene;


import elements.AmbientLight;
import elements.Camera;
import geometries.Geometries;
import geometries.Intersectable;
import primitives.Color;

public class Scene {
    String _name;
    Color _background;
    AmbientLight _ambientLight;
    Geometries _geometries;
    Camera _camera;
    double _distance;

    /**
     * Ctor, accept name only, and crate an empty collection of Geometries.
     *
     * @param name = _name of the scene
     */
    public Scene(String name) {
        this._name = name;
        this._geometries = new Geometries();
    }

    /**
     * getter
     *
     * @return AmbientLight object of ambient light in scene
     */
    public AmbientLight get_ambientLight() {
        return _ambientLight;
    }

    /**
     * setter
     *
     * @param _ambientLight = ambient light
     */
    public void set_ambientLight(AmbientLight _ambientLight) {
        this._ambientLight = _ambientLight;
    }

    /**
     * getter
     *
     * @return camera object of scene
     */
    public Camera get_camera() {
        return _camera;
    }

    /**
     * setter
     *
     * @param _camera = camera object in scene
     */
    public void set_camera(Camera _camera) {
        this._camera = _camera;
    }

    /**
     * getter
     *
     * @return Color object of background in scene
     */
    public Color get_background() {
        return _background;
    }

    /**
     * setter
     *
     * @param _background = background Color in scene
     */
    public void set_background(Color _background) {
        this._background = _background;
    }

    /**
     * getter
     *
     * @return the distance between camera to view plane
     */
    public double get_distance() {
        return _distance;
    }

    /**
     * setter
     *
     * @param _distance = update method to distance between camera and the view plane
     */
    public void set_distance(double _distance) {
        this._distance = _distance;
    }

    /**
     * getter
     *
     * @return list of Geometries objects in scene
     */
    public Geometries get_geometries() {
        return _geometries;
    }

    /**
     * getter
     *
     * @return the name of the scene
     */
    public String get_name() {
        return _name;
    }

    /**
     * add geom' objects to scene
     *
     * @param geometries to add
     */
    public void addGeometries(Intersectable... geometries) {
        for (Intersectable partOf : geometries) {
            this._geometries.add(partOf);
        }
    }
}
