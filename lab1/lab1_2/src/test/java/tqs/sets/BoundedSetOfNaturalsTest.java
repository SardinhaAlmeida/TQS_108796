/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tqs.sets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import tqs.sets.BoundedSetOfNaturals;

/**
 * @author ico0
 */
class BoundedSetOfNaturalsTest {
    private BoundedSetOfNaturals setA;
    private BoundedSetOfNaturals setB;
    private BoundedSetOfNaturals setC;
    private BoundedSetOfNaturals setD;
    private BoundedSetOfNaturals setE;


    @BeforeEach
    public void setUp() {
        setA = new BoundedSetOfNaturals(1);
        setB = BoundedSetOfNaturals.fromArray(new int[]{10, 20, 30, 40, 50, 60});
        setC = BoundedSetOfNaturals.fromArray(new int[]{50, 60});
        setD = new BoundedSetOfNaturals(3); //added 
        setE = BoundedSetOfNaturals.fromArray(new int[]{10, 20, 30, 40, 50, 60});
    }

    @AfterEach
    public void tearDown() {
        setA = setB = setC = setD = setE = null;
    }

    // @Disabled("TODO revise test logic")
    @DisplayName("Test add element")
    @Test
    public void testAddElement() {

        setA.add(99);
        assertTrue(setA.contains(99), "add: added element not found in set.");
        assertEquals(1, setA.size());

        // setB.add(11);
        // assertTrue(setB.contains(11), "add: added element not found in set.");
        // assertEquals(7, setB.size(), "add: elements count not as expected.");

        //testing adding to full set
        assertThrows(IllegalArgumentException.class, () -> setB.add(11), "add: adding element to full set must fail.");
        
        //testing adding negative number
        assertThrows(IllegalArgumentException.class, () -> setD.add(-11), "add: adding negative number must fail.");

        //testing adding duplicate
        setD.add(10);
        assertThrows(IllegalArgumentException.class, () -> setD.add(10), "add: adding duplicate must fail.");
    }

    //@Disabled("TODO revise to test the construction from invalid arrays")
    @DisplayName("Test add from bad array")
    @Test
    public void testAddFromBadArray() {
        int[] elems = new int[]{10, -20, -30};

        // must fail with exception
        assertThrows(IllegalArgumentException.class, () -> setA.add(elems));
    }

    @DisplayName("Test intersects")
    @Test
    public void testIntersects() {
        assertTrue(setB.intersects(setC), "intersects: sets should intersect.");
        assertFalse(setA.intersects(setB), "intersects: sets should not intersect.");
    }

    @DisplayName("Test equals")
    @Test
    public void testEquals() {
        
        Integer[] a = {10, 20}; //doesn't make much sense, but it's just to test

        assertTrue(setE.equals(setE), "equals: set should be equal to itself.");
        assertFalse(setE.equals(a), "equals: set should not be equal to an integer.");
        assertFalse(setE.equals(null), "equals: set should not be equal to null.");//doesn't make much sense, but it's just to test
    }

    @DisplayName("Test hashCode")
    @Test
    public void testHashCode() {

        assertEquals(setB.hashCode(), setE.hashCode(), "hashCode: equal sets should have equal hash codes.");
        assertNotEquals(setC.hashCode(), setE.hashCode(), "hashCode: different sets should have different hash codes.");
    }


}
