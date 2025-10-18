public class HashTableTest {
    private HashTable hashTable;

    @BeforeEach
    public void setUp() {
        hashTable = new HashTable(10, 1);
    }

    @Test
    public void testPutAndFind() {
        assertEquals(3, hashTable.put("mouse"));
        assertEquals(3, hashTable.find("mouse"));
    }

    @Test
    public void testPutAndFind() {
        assertEquals(0, hashTable.put("mouse"));
        assertEquals(0, hashTable.find("mouse"));
    }

    @Test
    public void testCollisionHandling() {
        hashTable.put("mouse");
        hashTable.put("keyboard");

        assertEquals(9, hashTable.find("keyboard"));
    }

    @Test
    public void testDuplicateInsertion() {
        assertEquals(3, hashTable.put("mouse")); 
        assertEquals(-1, hashTable.put("mouse")); 
    }

    @Test
    public void testFindNonExistentElement() {
        assertEquals(-1, hashTable.find("non")); 
    }

    @Test
    public void testFullTable() {
        for (int i = 0; i < 10; i++) {
            hashTable.put("item" + i);
        }
        assertEquals(-1, hashTable.put("overflow")); 
    }

    @Test
    public void testSeekSlotWithCollisions() {
        hashTable.put("mouse");
        hashTable.put("keyboard"); 

        int expectedIndex = hashTable.seekSlot("keyboard");
        assertTrue(expectedIndex > 0); 
        assertEquals(expectedIndex, hashTable.find("keyboard")); 
    }
}




