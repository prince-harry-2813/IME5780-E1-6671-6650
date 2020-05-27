package unittests;

import geometries.Geometries;
import geometries.Plane;
import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

public class GeometriesTests {
    @Test
    public void testFindIntersections() {

        Geometries collection = new Geometries();
        collection.add(new Plane(new Point3D(1, 0, 0), new Vector(0, 0, 1)));
    }

}
