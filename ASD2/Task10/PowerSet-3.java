import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class PowerSetTest {

        private PowerSet set = new PowerSet();
        private PowerSet set1 = new PowerSet();
        private PowerSet set2 = new PowerSet();
    
    @BeforeEach
    void setUp() {
        set = new PowerSet();
        set1 = new PowerSet();
        set2 = new PowerSet();
    }

    @Test
    public void testPut() {
        
        set.put("A");
        assertTrue(set.get("A"));

        set.put("A");
        assertEquals(1, set.size());
    }

    @Test
    public void testRemove() {
        set.put("A");
        assertTrue(set.remove("A"));
        assertFalse(set.get("A"));
    }

    @Test
    public void testIntersection() {
        set1.put("A");
        set1.put("B");
        
        set2.put("B");
        set2.put("C");

        PowerSet intersection = set1.intersection(set2);
        assertNotNull(intersection);
        assertEquals(1, intersection.size());
        
        PowerSet emptySet = new PowerSet();
        PowerSet emptyIntersection = set1.intersection(emptySet);
        assertNotNull(emptyIntersection);
    }

    @Test
    public void testUnion() {
        set1.put("A");
        set1.put("B");
        
        set2.put("B");
        set2.put("C");

        PowerSet union = set1.union(set2);
        

        assertNotNull(union);
        assertEquals(3, union.size());

        PowerSet emptySet = new PowerSet();
        PowerSet unionWithEmpty = set1.union(emptySet);
        assertNotNull(unionWithEmpty);
        assertEquals(2, unionWithEmpty.size());
    }

    @Test
    public void testDifference() {
        set1.put("A");
        set1.put("B");
        set1.put("D");
        set1.put("E");
        
        set2.put("B");
        set2.put("C");
        
        PowerSet difference = set1.difference(set2);

        assertNotNull(difference);
        assertEquals(3, difference.size());

    }

    @Test
    public void testIsSubset() {
        set1.put("A");
        set1.put("B");

        set2.put("A");
        assertTrue(set1.isSubset(set2));

        set2.put("B");
        assertTrue(set2.isSubset(set1));

        PowerSet set3 = new PowerSet();
        set3.put("B");
        set3.put("C");
        assertFalse(set1.isSubset(set3));
    }

    @Test
    public void testEquals() {

        assertTrue(set1.equals(set2));

        set1.put("A");
        set1.put("B");

        assertFalse(set1.equals(set2));

        set2.put("A");
        set2.put("B");

        assertTrue(set1.equals(set2));

        set2.remove("B");
        assertFalse(set1.equals(set2));
    }

    @Test
    public void testPerformance() {
        long startTime = System.currentTimeMillis();
        PowerSet largeSet = new PowerSet();
        
        for (int i = 0; i < 10000; i++) {
            largeSet.put(String.valueOf(i));
        }

        for (int i = 0; i < 10000; i++) {
            largeSet.remove(String.valueOf(i));
        }

        long endTime = System.currentTimeMillis();
        
        assertTrue(endTime - startTime < 2000);
    }

    @Test
    public void testPut10000() {
        for(int i = 0; i < 100; i++) {
            String str = "Value " + i;
            set.put(str);
        }
    }

        //
    // Неверное удаление элемента из непустого множества
    //

    @Test
    public void testRemoveExistingElement() {
        powerSet.put("test");
        assertTrue(powerSet.remove("test"));
        assertFalse(powerSet.get("test"));
        assertEquals(0, powerSet.size());
    }

    @Test
    public void testRemoveNonExistingElement() {
        powerSet.put("test");
        assertFalse(powerSet.remove("nonexistent"));
        assertTrue(powerSet.get("test"));
        assertEquals(1, powerSet.size());
    }

    @Test
    public void testRemoveMultipleElements() {
        powerSet.put("one");
        powerSet.put("two");
        powerSet.put("three");

        assertTrue(powerSet.remove("two"));
        assertFalse(powerSet.get("two"));
        assertEquals(2, powerSet.size());

        assertTrue(powerSet.remove("one"));
        assertFalse(powerSet.get("one"));
        assertEquals(1, powerSet.size());

        assertTrue(powerSet.remove("three"));
        assertFalse(powerSet.get("three"));
        assertEquals(0, powerSet.size());
    }

    @Test
    public void testRemoveFromEmptySet() {
        assertFalse(powerSet.remove("nonexistent"));
        assertEquals(0, powerSet.size());
    }

    @Test
    public void testRemoveAfterResize() {

        for (int i = 0; i < 20000; i++) {
            powerSet.put("element" + i);
        }

        assertTrue(powerSet.remove("element1000"));
        assertTrue(powerSet.remove("element5000"));
        
        for (int i = 0; i < 20000; i++) {
            //System.out.println(i + " " + String.valueOf(powerSet.get("element" + i)));
            assertTrue(powerSet.get("element" + i));
        }

        //assertEquals(19998, powerSet.size());
    }
}












