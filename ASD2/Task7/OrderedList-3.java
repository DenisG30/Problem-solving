public class OrderedListTest {
    private OrderedList<Integer> orderedListAsc;
    private OrderedList<Integer> orderedListDesc;

    @BeforeEach
    public void setUp() {
        orderedListAsc = new OrderedList<>(true);
        orderedListDesc = new OrderedList<>(false);
    }

    @Test
    public void testAddAscending() {
        orderedListAsc.add(3);
        orderedListAsc.add(1);
        orderedListAsc.add(2);

        ArrayList<Node<Integer>> elements = orderedListAsc.getAll();
        assertEquals(3, elements.size());
        assertEquals(1, elements.get(0).value);
        assertEquals(2, elements.get(1).value);
        assertEquals(3, elements.get(2).value);
    }

    @Test
    public void testAddDescending() {
        orderedListDesc.add(1);
        orderedListDesc.add(3);
        orderedListDesc.add(2);

        ArrayList<Node<Integer>> elements = orderedListDesc.getAll();
        assertEquals(3, elements.size());
        assertEquals(1, elements.get(0).value);
        assertEquals(2, elements.get(1).value);
        assertEquals(3, elements.get(2).value);
    }

    @Test
    public void testFindExistingElement() {
        orderedListAsc.add(1);
        orderedListAsc.add(2);
        orderedListAsc.add(3);

        Node<Integer> foundNode = orderedListAsc.find(2);
        assertNotNull(foundNode);
        assertEquals(2, foundNode.value);
    }

    @Test
    public void testFindNonExistingElement() {
        orderedListAsc.add(1);
        orderedListAsc.add(3);

        Node<Integer> foundNode = orderedListAsc.find(2);
        assertNull(foundNode);
    }

    @Test
    public void testDeleteExistingElement() {
        orderedListAsc.add(1);
        orderedListAsc.add(2);
        orderedListAsc.add(3);

        orderedListAsc.delete(2);

        ArrayList<Node<Integer>> elements = orderedListAsc.getAll();
        assertEquals(2, elements.size());
        assertEquals(1, elements.get(0).value);
        assertEquals(3, elements.get(1).value);
    }

    @Test
    public void testDeleteNonExistingElement() {
        orderedListAsc.add(1);
        orderedListAsc.add(2);

        orderedListAsc.delete(3);

        ArrayList<Node<Integer>> elements = orderedListAsc.getAll();
        assertEquals(2, elements.size());
    }

    @Test
    public void testDeleteHeadElement() {
        orderedListAsc.add(1);
        orderedListAsc.add(2);
        orderedListAsc.add(3);

        orderedListAsc.delete(1);

        ArrayList<Node<Integer>> elements = orderedListAsc.getAll();
        assertEquals(2, elements.size());
        assertEquals(2, elements.get(0).value);
        assertEquals(3, elements.get(1).value);
    }

    @Test
    public void testDeleteTailElement() {
        orderedListAsc.add(1);
        orderedListAsc.add(2);
        orderedListAsc.add(3);

        orderedListAsc.delete(3);

        ArrayList<Node<Integer>> elements = orderedListAsc.getAll();
        assertEquals(2, elements.size());
        assertEquals(1, elements.get(0).value); 
        assertEquals(2, elements.get(1).value);
    }
}
