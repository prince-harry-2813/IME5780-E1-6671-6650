package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.List;

public class Geometries implements Intersectable {

    List<Intersectable> geomList = new ArrayList<Intersectable>();

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
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> intersectionPoints = null; // if there is no interesection that will return null list
        for (Intersectable partOf : geomList) {
            List<Point3D> temp = partOf.findIntersections(ray); //check every object
            if (temp != null) {  //in case there is intersection  points
                if (intersectionPoints == null) {
                    intersectionPoints = new ArrayList<Point3D>();
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
