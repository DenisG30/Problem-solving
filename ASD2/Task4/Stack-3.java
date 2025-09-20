public class StackTest {
    private Stack<Object> stack;

    @BeforeEach
    public void setup(){
         stack = new Stack<>(); 
    }
      
    @Test
    public void testPushAndPopWithDifferentTypes() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.peek());
        stack.pop();
        assertEquals(2, stack.peek());

         
        stack.push("Hello");
        assertEquals("Hello", stack.pop()); 
        assertEquals(2, stack.pop());
        stack.pop();
        assertNull(stack.pop()); 
    }

    @Test
    public void testPeekWithDifferentTypes() {
        assertNull(stack.peek());
        stack.push(1);
        stack.push("World");
        assertEquals("World", stack.peek()); 
    }

    @Test
    public void testSizeWithDifferentTypes() {
        assertEquals(0, stack.size()); 
        stack.push(1);
        assertEquals(1, stack.size()); 
        stack.push("Test");
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }
}
    


