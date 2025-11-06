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
        
        set2.put("C");
        
        PowerSet difference = set1.difference(set2);
        assertNotNull(difference);
        assertEquals(1, difference.size());

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
        set3.put("C");
        assertFalse(set1.isSubset(set3));
    }

    @Test
    public void testEquals() {

        set1.put("A");
        set1.put("B");

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
}
