import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
    
public class NativeCashTest {
    private NativeCache<String> cache;

    @BeforeEach
    public void setUp() {
        cache = new NativeCache<>(5);
    }

    @Test
    void testPutAndGetWithCollisions() {
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");
        cache.put("key4", "value4");
        cache.put("key5", "value5");

        assertEquals("value1", cache.get("key1"));
        assertEquals("value2", cache.get("key2"));
        assertEquals("value3", cache.get("key3"));
        assertEquals("value4", cache.get("key4"));
        assertEquals("value5", cache.get("key5"));
        
        assertEquals(2, cache.hits[cache.hash("key1")]);
        assertEquals(2, cache.hits[cache.hash("key2")]);
        assertEquals(2, cache.hits[cache.hash("key3")]);
        assertEquals(2, cache.hits[cache.hash("key4")]);
        assertEquals(2, cache.hits[cache.hash("key5")]);

        cache.get("key1");
        cache.get("key2");

        assertEquals(3, cache.hits[cache.hash("key1")]);
        assertEquals(3, cache.hits[cache.hash("key2")]);
    }

    @Test
    void testEvictionOnFullCache() {
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");
        cache.put("key4", "value4");
        cache.put("key5", "value5");

        cache.get("key2");
        cache.get("key3");
        cache.get("key4");
        cache.get("key5");

        cache.put("key6", "value6");
        
        assertNull(cache.get("key1"));

        cache.get("key3");
        cache.get("key4");
        cache.get("key5");
        cache.get("key6");
        cache.get("key6");

        cache.put("key7", "value7");

        assertNull(cache.get("key2"));
    }

    @Test
    void testRemoveKey() {
        cache.put("key1", "value1");
        cache.put("key2", "value2");

        cache.remove("key1");

        assertNull(cache.get("key1"));
        assertNotNull(cache.get("key2"));
        
        assertEquals(0, cache.hits[cache.hash("key1")]);
    }
}






    
