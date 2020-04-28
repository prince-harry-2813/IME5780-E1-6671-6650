package unittests;

import geometries.Cylinder;
import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

public class CylinderTest {
    @Test
    public void testGetNormal() {
        Cylinder cyl = new Cylinder(1., new Point3D(0, 0, 1), new Vector(0, 1, 0), 1.);
        Vector result = new Vector(cyl.getNormal(new Point3D(1, 2, 3)));
        result.toString();
        //to be continued
    }

}