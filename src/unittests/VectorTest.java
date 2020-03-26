package unittests;

import org.junit.Test;
import primitives.Vector;

import static org.junit.Assert.*;
import static primitives.Util.isZero;

/**
 * unit tests for primitives.Vector class
 *
 * @author yossef steinmetz & arie rosental
 */
public class VectorTest {

    /**
     * test method for {@link primitives.Vector#subtract(Vector)}
     */
    @Test
    public void testSubtract() {

    }

    /**
     * test method for {@link primitives.Vector#add(Vector)}
     */
    @Test
    public void testAdd() {
    }

    /**
     * test method for {@link primitives.Vector#scale(double)}
     */
    @Test
    public void testScale() {
    }

    /**
     * test method for {@link primitives.Vector#dotProduct(Vector)}
     */
    @Test
    public void testDotProduct() {
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

    }

    /**
     * test method for {@link Vector#length()}
     */
    @Test
    public void testLength() {
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