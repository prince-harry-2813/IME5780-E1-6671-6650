package scene;


import elements.AmbientLight;
import elements.Camera;
import elements.LightSource;
import geometries.Geometries;
import geometries.Intersectable;
import primitives.Color;

import java.util.LinkedList;
import java.util.List;

public class Scene {
    private final String _name;
    private final Geometries _geometries;
    private Color _background;
    private AmbientLight _ambientLight;
    private Camera _camera;
    private double _distance;
    private List<LightSource> _lights = new LinkedList<LightSource>();

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
    public AmbientLight get_AmbientLight() {
        return _ambientLight;
    }

    /**
     * setter
     *
     * @param _ambientLight = ambient light
     */
    public void set_AmbientLight(AmbientLight _ambientLight) {
        this._ambientLight = _ambientLight;
    }

    /**
     * getter
     *
     * @return camera object of scene
     */
    public Camera get_Camera() {
        return _camera;
    }

    /**
     * setter
     *
     * @param _camera = camera object in scene
     */
    public void set_Camera(Camera _camera) {
        this._camera = _camera;
    }

    /**
     * getter
     *
     * @return Color object of background in scene
     */
    public Color get_Background() {
        return _background;
    }

    /**
     * setter
     *
     * @param _background = background Color in scene
     */
    public void set_Background(Color _background) {
        this._background = _background;
    }

    /**
     * getter
     *
     * @return the distance between camera to view plane
     */
    public double get_Distance() {
        return _distance;
    }

    /**
     * setter
     *
     * @param _distance = update method to distance between camera and the view plane
     */
    public void set_Distance(double _distance) {
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

    /**
     * getter
     *
     * @return list of light objects
     */
    public List<LightSource> get_lights() {
        return _lights;
    }

    /**
     * add method to list of light object
     *
     * @param light light source list
     */
    public void addLights(LightSource light) {
        if (_lights == null) {
            _lights = new LinkedList<>();
        }
        _lights.add(light);
    }
}
