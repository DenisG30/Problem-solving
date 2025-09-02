// Task 2. Bidirectional linked list

// Exercise No.8 
// Tests for exercises 1-7

public class LinkedList2Test {
    private LinkedList2 list;

    @BeforeEach
    public void setUp() {
        list = new LinkedList2();
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
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);

        list.addInTail(firstNode);
        list.addInTail(secondNode);
        list.addInTail(thirdNode);

        assertEquals(firstNode, list.find(1));
        assertEquals(secondNode, list.find(2));
        assertEquals(thirdNode, list.find(3));
        assertNull(list.find(4));
    }

    @Test
    public void testFindAllInEmptyList() {
        ArrayList<Node> result = list.findAll(1);
        assertTrue(result.isEmpty());
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    public void testFindAllInSingleElementList() {
        Node firstNode = new Node(1);
        list.addInTail(firstNode);

        ArrayList<Node> result = list.findAll(1);
        assertEquals(1, result.size());
        assertEquals(firstNode, result.get(0));
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
        assertNull(list.head); 
        assertNull(list.tail); 
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
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);

        list.addInTail(firstNode);
        list.addInTail(secondNode);
        list.addInTail(thirdNode);

        assertTrue(list.remove(2)); 
        assertSame(firstNode, list.head); 
        assertSame(thirdNode, list.tail); 
        assertSame(thirdNode.prev, firstNode); 
        assertTrue(list.remove(1)); 
        assertSame(thirdNode, list.head); 
        assertNull(thirdNode.prev);

        assertTrue(list.remove(3)); 
        assertNull(list.head); 
        assertNull(list.tail);
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
        assertNull(list.head.prev);
        assertNull(list.head.next);
    }

    @Test
    public void testInsertAfterInSingleElementList() {
        Node firstNode = new Node(1);
        list.addInTail(firstNode);
        
        Node nodeToInsert = new Node(2);
        
        list.insertAfter(firstNode, nodeToInsert);
        
        assertEquals(nodeToInsert, firstNode.next);
        assertEquals(firstNode, nodeToInsert.prev);
        assertEquals(nodeToInsert, list.tail);
        assertNull(list.tail.next);
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
        assertEquals(firstNode, nodeToInsert.prev);
        assertEquals(secondNode, list.tail); 
    }
}
  


    


