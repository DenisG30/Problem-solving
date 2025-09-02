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
    public void testReverseLinkedList() {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourNode = new Node(4);
        Node fiveNode = new Node(5);

        list.addInTail(firstNode);
        list.addInTail(secondNode);
        list.addInTail(thirdNode);
        list.addInTail(fourNode);
        list.addInTail(fiveNode);


        list.reverse();

        assertEquals(fiveNode, list.head);
        assertEquals(firstNode, list.tail);
    }


    @Test
    public void testCycleTrueLinkedList() {
        
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);

        list.addInTail(firstNode);
        list.addInTail(secondNode);
        list.addInTail(thirdNode);

        // Создаем цикл
        thirdNode.next = firstNode; // Замыкаем третий узел на первый

        assertTrue(list.cycle());
    }

    @Test
    public void testCycleFalseLinkedList() {
        
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);

        list.addInTail(firstNode);
        list.addInTail(secondNode);
        list.addInTail(thirdNode);

        assertFalse(list.cycle());
    }
}
    


