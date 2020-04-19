package unittests;

import geometries.Triangle;
import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.Assert.assertEquals;

public class TriangleTest {
    @Test
    public void testGetNormal() {
        Triangle tri = new Triangle(new Point3D(1, 0, 0), new Point3D(0, 1, 0), new Point3D(0, 0, 1));
        assertEquals("wrong triangle normal", new Vector(Math.sqrt(1. / 3), Math.sqrt(1. / 3), Math.sqrt(1. / 3)), tri.getNormal(new Point3D(1, 0, 0)));
    }
}