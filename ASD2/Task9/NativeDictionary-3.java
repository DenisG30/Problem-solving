class NativeDictionaryTest {

    private NativeDictionary<String> dictionary;

    @BeforeEach
    void setUp() {
        dictionary = new NativeDictionary<>(10, String.class);
    }

    @Test
    void testPutAndGetNewKey() {
        dictionary.put("key1", "value1");
        assertTrue(dictionary.isKey("key1"));
        assertEquals("value1", dictionary.get("key1"));
    }

    @Test
    void testPutAndUpdateExistingKey() {
        dictionary.put("key1", "value1");
        dictionary.put("key1", "value2");
        assertEquals("value2", dictionary.get("key1"));
    }

    @Test
    void testIsKeyForExistingKey() {
        dictionary.put("key1", "value1");
        assertTrue(dictionary.isKey("key1"));
    }

    @Test
    void testIsKeyForNonExistingKey() {
        assertFalse(dictionary.isKey("key2"));
    }

    @Test
    void testGetForExistingKey() {
        dictionary.put("key1", "value2");
        assertEquals("value2", dictionary.get("key1"));
    }

    @Test
    void testGetForNonExistingKey() {
        assertNull(dictionary.get("key2"));
    }
}



