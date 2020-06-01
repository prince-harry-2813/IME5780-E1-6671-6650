package unittests;

import geometries.Cylinder;
import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.Assert.assertEquals;

public class CylinderTest {
    @Test
    public void testGetNormal() {
        Cylinder cyl = new Cylinder(1., new Point3D(0, 0, 1), new Vector(0, 1, 0), 1.);
        Vector result = new Vector(cyl.getNormal(new Point3D(1, 2, 3)));
        assertEquals("Wrong results", new Vector(0.3333333333333333, 0.6666666666666666, 0.6666666666666666), result);
        //to be continued

    }

}