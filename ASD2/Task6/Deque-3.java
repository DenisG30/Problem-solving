public class DequeTest {
    private Deque<Integer> deque;

    @Before
    public void setUp() {
        deque = new Deque<>();
    }

    @Test
    public void testAddFront() {
        deque.addFront(1);
        assertEquals(1, deque.size());
        assertNotNull(deque.head);
        assertEquals(Integer.valueOf(1), deque.head.value);
        
        deque.addFront(2);
        assertEquals(2, deque.size());
        assertNotNull(deque.head);
        assertEquals(Integer.valueOf(2), deque.head.value);
    }

    @Test
    public void testAddTail() {
        deque.addTail(1);
        assertEquals(1, deque.size());
        assertNotNull(deque.tail);
        assertEquals(Integer.valueOf(1), deque.tail.value);
        
        deque.addTail(2);
        assertEquals(2, deque.size());
        assertNotNull(deque.tail);
        assertEquals(Integer.valueOf(2), deque.tail.value);
    }

    @Test
    public void testRemoveFront() {
        deque.addFront(1);
        deque.addFront(2);
        
       deque.removeFront();
        assertEquals(1, deque.size());
        assertNotNull(deque.head);
        assertEquals(Integer.valueOf(1), deque.head.value);
        
        deque.removeFront();
        assertEquals(0, deque.size());
        assertNull(deque.head);
    }

    @Test
    public void testRemoveTail() {
        deque.addTail(1);
        deque.addTail(2);
        
        deque.removeTail();
        assertEquals(1, deque.size());
        assertNotNull(deque.tail);
        assertEquals(Integer.valueOf(1), deque.tail.value);
        
        deque.removeTail();
        assertEquals(0, deque.size());
        assertNull(deque.tail);
    }

    @Test
    public void testSize() {
        assertEquals(0, deque.size());
        
        deque.addFront(1);
        assertEquals(1, deque.size());
        
        deque.addTail(2);
        assertEquals(2, deque.size());
        
        deque.removeFront();
        assertEquals(1, deque.size());
        
        deque.removeTail();
        assertEquals(0, deque.size());
    }
}
    
