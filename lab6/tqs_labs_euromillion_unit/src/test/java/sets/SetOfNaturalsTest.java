/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.util.Objects;

/**
 * @author ico0
 */
public class SetOfNaturalsTest {
    private SetOfNaturals setA;
    private SetOfNaturals setB;
    private SetOfNaturals setC;
    private SetOfNaturals setD;

    @BeforeEach
    public void setUp() {
        setA = new SetOfNaturals();
        setB = SetOfNaturals.fromArray(new int[]{10, 20, 30, 40, 50, 60});

        setC = new SetOfNaturals();
        for (int i = 5; i < 50; i++) {
            setC.add(i * 10);
        }
        setD = SetOfNaturals.fromArray(new int[]{30, 40, 50, 60, 10, 20});
    }

    @AfterEach
    public void tearDown() {
        setA = setB = setC = setD = null;
    }

    @Test
    public void testAddElement() {

        setA.add(99);
        assertTrue(setA.contains(99), "add: added element not found in set.");
        assertEquals(1, setA.size());

        setB.add(11);
        assertTrue(setB.contains(11), "add: added element not found in set.");
        assertEquals(7, setB.size(), "add: elements count not as expected.");
    }

    @Test
    public void testIntersectForNoIntersection() {
        assertFalse(setA.intersects(setB), "no intersection but was reported as existing");
    }

    @Test
    public void testIntersectForIntersection(){
        assertTrue(setB.intersects(setD), "sets with common values are not returning true");
    }

    @Test
    public void testAddBadArray() {
        int[] elems = new int[]{10, 20, -30};

        // must fail with exception
        assertThrows(IllegalArgumentException.class, () -> setA.add(elems));
    }

    @Test
    public void testAddDuplicate(){
        int[] duplicate = new int[]{10};
        assertThrows(IllegalArgumentException.class, () -> setB.add(duplicate), "the value 10 is already in the set, cannot be added (no duplicates)");
    }

    /*
    @Test
    public void testEquals(){
        SetOfNaturals setTest = SetOfNaturals.fromArray(new int[]{10, 20, 30, 40, 50, 60});
        assertTrue(setB.equals(setTest), "equal sets don't return as being equal");

        int[] testDifClasses = new int[]{2,3,4};
        assertFalse(setB.equals(testDifClasses), "objects of different classes cannot be equal");
    }
    */
}
