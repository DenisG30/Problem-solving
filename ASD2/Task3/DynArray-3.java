// Task 3. Dynamic arrays

// Exercise No.5
// Tests for exercises 1-3

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DynArrayTest {
    private DynArray<Integer> dynArray;

    @BeforeEach
    public void setUp() {
        dynArray = new DynArray<>(Integer.class);
    }

    @Test
    public void testInsertWithinCapacity() {
        dynArray.append(1);
        dynArray.append(2);
        dynArray.append(3);
        int initialCapacity = dynArray.capacity;

        dynArray.insert(4, 1);

        assertEquals(4, dynArray.count);
        assertEquals(initialCapacity, dynArray.capacity);
        assertEquals(1, dynArray.getItem(0));
        assertEquals(4, dynArray.getItem(1));
        assertEquals(2, dynArray.getItem(2));
        assertEquals(3, dynArray.getItem(3));
    }

    @Test
    public void testInsertExceedingCapacity() {
        for (int i = 0; i < 16; i++) {
            dynArray.append(i);
        }
        int initialCapacity = dynArray.capacity;

        dynArray.insert(99, 8);

        assertEquals(17, dynArray.count);
        assertTrue(dynArray.capacity > initialCapacity);
        assertEquals(99, dynArray.getItem(8));
    }

    @Test
    public void testInsertInvalidIndex() {
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            dynArray.insert(1, -1);
        }, "Going beyond borders");
        assertTrue(exception.getMessage().contains("Going beyond borders"));

        exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            dynArray.insert(1, 1);
        });
        assertTrue(exception.getMessage().contains("Going beyond borders"));
    }

     @Test
    public void testRemoveWithinCapacity2048() {
        for (int i = 1; i < 1048; i++) {
            dynArray.append(i);
        }
        
        
        if (dynArray.capacity == 2048) {
            for(int i = 0; i < 1001; i++) {
                dynArray.remove(dynArray.count - 1);
            }
        }
        assertEquals(46, dynArray.count);
        assertEquals(79, dynArray.capacity);
    }

    @Test
    public void testRemoveWithinCapacity() {
        dynArray.append(1);
        dynArray.append(2);
        dynArray.append(3);
        
        int initialCapacity = dynArray.capacity;
        
        dynArray.remove(1);

        assertEquals(2, dynArray.count);
        assertEquals(initialCapacity, dynArray.capacity);
        assertEquals(1, dynArray.getItem(0));
        assertEquals(3, dynArray.getItem(1));
    }

    @Test
    public void testRemoveDecreasingCapacity() {
        for (int i = 0; i < 16; i++) {
            dynArray.append(i);
        }
        
        int initialCapacity = dynArray.capacity;

        for (int i = 0; i < 12; i++) {
            dynArray.remove(0); 
        }

        assertEquals(4, dynArray.count);
        assertTrue(dynArray.capacity < initialCapacity);
    }

    @Test
    public void testRemoveInvalidIndex() {
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            dynArray.remove(-1);
        });
        assertTrue(exception.getMessage().contains("Going beyond borders"));

        exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            dynArray.remove(0);
        });
        
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            dynArray.remove(0);
        });
    }
}

    
