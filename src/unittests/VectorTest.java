package unittests;

import org.junit.Test;
import primitives.Vector;

import static org.junit.Assert.*;
import static primitives.Util.isZero;

/**
 * unit tests for primitives.Vector class
 *
 * @author yossef steinmetz and arie rosental
 */
public class VectorTest {

    /**
     * test method for {@link primitives.Vector#subtract(Vector)}
     */
    @Test
    public void testSubtract() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v3 = new Vector(0, 3, -2);
        assertEquals("ERROR: subtract() wrong value", v1.subtract(v3).getHead().getY(), 1, 0.00001);
        assertEquals("ERROR: subtract() wrong value", v1.subtract(v3).getHead().getX(), -1, 0.00001);

    }

    /**
     * test method for {@link primitives.Vector#add(Vector)}
     */
    @Test
    public void testAdd() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v3 = new Vector(0, 3, -2);
        assertEquals("ERROR: add() wrong value", v1.add(v3).getHead().getY(), 5, 0.00001);
        assertEquals("ERROR: add() wrong value", v1.add(v3).getHead().getX(), 1.0, 0.00001);
    }

    /**
     * test method for {@link Vector#scale(double)}
     */
    @Test
    public void testScale() {
        Vector v3 = new Vector(0, 3, -2);
        assertTrue("ERROR: scale() wrong value", isZero(v3.scale(23).getHead().getX()));
        assertEquals("ERROR: scale() wrong value", v3.scale(23).getHead().getZ(), -46);
    }

    /**
     * test method for {@link primitives.Vector#dotProduct(Vector)}
     */
    @Test
    public void testDotProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(-2, -4, -6);
        Vector v3 = new Vector(0, 3, -2);
        assertTrue("ERROR: dotProduct() for orthogonal vectors is not zero", isZero(v1.dotProduct(v3)));
        assertTrue("ERROR: dotProduct() wrong value", isZero(v1.dotProduct(v2) + 28));
    }

    /**
     * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
     */
    @Test
    public void testCrossProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(-2, -4, -6);

        // ============ Equivalence Partitions Tests ==============
        Vector v3 = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v3);

        // Test that length of cross-product is proper (orthogonal vectors taken for simplicity)
        assertEquals("crossProduct() wrong result length", v1.length() * v3.length(), vr.length(), 0.00001);

        // Test cross-product result orthogonality to its operands
        assertTrue("crossProduct() result is not orthogonal to 1st operand", isZero(vr.dotProduct(v1)));
        assertTrue("crossProduct() result is not orthogonal to 2nd operand", isZero(vr.dotProduct(v3)));

        // =============== Boundary Values Tests ==================
        // test zero vector from cross-productof co-lined vectors
        try {
            v1.crossProduct(v2);
            fail("crossProduct() for parallel vectors does not throw an exception");
        } catch (Exception e) {
        }
    }

    /**
     * test method for {@link Vector#lengthSquared()}
     */
    @Test
    public void testLengthSquared() {
        Vector v1 = new Vector(1, 2, 3);
        assertTrue("ERROR: lengthSquared() wrong value", (isZero(v1.lengthSquared() - 14)));
    }

    /**
     * test method for {@link Vector#length()}
     */
    @Test
    public void testLength() {
        assertTrue("ERROR: length() wrong value", isZero(new Vector(0, 3, 4).length() - 5));


    }

    /**
     * test method for {@link Vector#normalize()}
     */
    @Test
    public void testNormalize() {

    }

    /**
     * test method for {@link Vector#normalized()}
     */
    @Test
    public void testNormalized() {
    }
}