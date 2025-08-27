// Task 1. Linked list

// Exercise No.7 
// Tests for exercises 1-6

public class LinkedListTest {
    private LinkedList list;

    @BeforeEach
    public void setUp() {
        list = new LinkedList();   
    }

    @Test
    public void testFindInEmptyList() {
          assertNull(list.find(1));
    }

    @Test
    public void testFindInSingleElementList() {
        Node node = new Node(1);
        list.addInTail(node);
        assertEquals(node, list.find(1));
        assertNull(list.find(2));
    }

    @Test
    public void testFindInMultipleElementList() {
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));

        assertEquals(2, list.find(2).value);
        assertNull(list.find(4));
    }

    @Test
    public void testFindAllInEmptyList() {
        assertTrue(list.findAll(1).isEmpty());
    }

    @Test
    public void testFindAllInSingleElementList() {
        Node node = new Node(1);
        list.addInTail(node);
        ArrayList<Node> foundNodes = list.findAll(1);
        
        assertEquals(1, foundNodes.size());
        assertEquals(node, foundNodes.get(0));
        
        assertTrue(list.findAll(2).isEmpty());
    }

    @Test
    public void testFindAllInMultipleElementList() {
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(1));
        
        ArrayList<Node> foundNodes = list.findAll(1);
        
        assertEquals(2, foundNodes.size());
        assertEquals(1, foundNodes.get(0).value);
        assertEquals(1, foundNodes.get(1).value);
    }

    @Test
    public void testRemoveFromEmptyList() {
        assertFalse(list.remove(1));
    }

    @Test
    public void testRemoveFromSingleElementList() {
        Node node = new Node(1);
        list.addInTail(node);

        assertTrue(list.remove(1));
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    public void testRemoveFromMultipleElementList() {
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));

        assertTrue(list.remove(2));
        assertNotNull(list.head.next); 
        assertEquals(3, list.head.next.value);

        assertFalse(list.remove(4)); 
    }

    @Test
    public void testRemoveAllFromEmptyList() {
        list.removeAll(1);
        assertTrue(list.head == null);
    }

    @Test
    public void testRemoveAllFromSingleElementList() {
        Node node = new Node(1);
        list.addInTail(node);

        list.removeAll(1);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    public void testRemoveAllFromMultipleElementList() {
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(1));
        
        list.removeAll(1);
        
        assertEquals(1, list.count()); 
        assertEquals(2, list.head.value);
    }

    @Test
    public void testClear() {
        list.addInTail(new Node(1));
        list.clear();
        
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    public void testCountOnEmptyList() {
        assertEquals(0, list.count());
    }

    @Test
    public void testCountOnSingleElementList() {
        list.addInTail(new Node(1));
        assertEquals(1, list.count());
    }

    @Test
    public void testCountOnMultipleElementList() {
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        
        assertEquals(2, list.count());
    }

    @Test
    public void testInsertAfterInEmptyList() {
              Node nodeToInsert = new Node(2);
        
        list.insertAfter(null, nodeToInsert);
        
        assertNotNull(list.head);
        assertEquals(nodeToInsert, list.head);
        assertEquals(nodeToInsert, list.tail);
    }

    @Test
    public void testInsertAfterInSingleElementList() {
        Node firstNode = new Node(1);
        list.addInTail(firstNode);
        
        Node nodeToInsert = new Node(2);
        
        list.insertAfter(firstNode, nodeToInsert);
        
        assertEquals(nodeToInsert, firstNode.next);
        assertEquals(nodeToInsert, list.tail);
    }

    @Test
    public void testInsertAfterInMultipleElementList() {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        
        list.addInTail(firstNode);
        list.addInTail(secondNode);

        Node nodeToInsert = new Node(3);

        list.insertAfter(firstNode, nodeToInsert);

        assertEquals(nodeToInsert, firstNode.next);
        assertEquals(secondNode, nodeToInsert.next);
        assertEquals(secondNode, list.tail); 
    }
}



