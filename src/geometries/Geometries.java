package geometries;

import primitives.Ray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Geometries implements Intersectable {
    /**
     * collect of geometries
     */
    List<Intersectable> geomList;

    /**
     * default ctor
     */
    public Geometries() {
        geomList = new ArrayList<Intersectable>();
    }

    /**
     * ctor of components in geometries
     *
     * @param geometries objects
     */
    public Geometries(Intersectable... geometries) {
        add(geometries);
    }

    /**
     * find intersection points in components of geometries
     *
     * @param ray that light on the objects
     * @return list of intersection points
     */
    @Override
    public List<GeoPoint> findIntersections(Ray ray) {
        List<GeoPoint> intersectionPoints = null; // if there is no intersection that will return null list
        for (Intersectable partOf : geomList) {
            List<GeoPoint> temp = partOf.findIntersections(ray); //check every object
            if (temp != null) {  //in case there is intersection  points
                if (intersectionPoints == null) {
                    intersectionPoints = new LinkedList<GeoPoint>();
                }
                intersectionPoints.addAll(temp);
            }
        }
        return intersectionPoints;
    }

    /**
     * adding operator to the list
     *
     * @param geometries objects to add
     */
    public void add(Intersectable... geometries) {
        for (Intersectable partOf : geometries) {
            geomList.add(partOf);
        }

    }

}
