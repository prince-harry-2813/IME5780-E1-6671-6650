package unittests;

import geometries.Tube;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.assertEquals;

public class TubeTest {
    /**
     * Test method for { @link  geometries.Tube#getNormal(Point3D)}.
     */
    @Test
    public void testGetNormal() {


        Ray r1 = new Ray(Point3D.ZERO, new Vector(0, 1, 0));
        Tube t1 = new Tube(1, r1);
        Vector v1 = new Vector(1, 2, 1);
        Ray r2 = new Ray(new Point3D(1, 2, 3), new Vector(1, 0, 2));
        Tube t2 = new Tube(2, r2);

        assertEquals(v1.subtract(new Vector(0, 2, 0)).scale(1d / Math.sqrt(2)), t1.getNormal(v1.getHead()));

        assertEquals(new Vector(-4, 0, 2).scale(1d / Math.sqrt(20)), t2.getNormal(new Point3D(0, 2, 11)));
    }
}
