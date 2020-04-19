package unittests;

import geometries.Sphere;
import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.Assert.assertTrue;

public class SphereTest {
    @Test
    public void testGetNormal() {
        Sphere sph = new Sphere(1.0, new Point3D(0.0, 0.0, 1.0));
        assertTrue("wrong normal sphere", new Vector(0.0, 0.0, 1.0).equals(sph.getNormal(new Point3D(0.0, 0.0, 2.0))));
    }

}