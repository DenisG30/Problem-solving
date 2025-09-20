public class Stack<T> {
    private Node<T> head;
    private int count;

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public Stack() {
        head = null;
        count = 0;
    }

    // Time complexity O(1)
    // Spatial complexity O(1)
    public int size() {
        return count; 
    }

    // Time complexity O(1)
    // Spatial complexity O(1)
    public T pop() {
        if (head == null) {
            return null; 
        }
        T value = head.value; 
        head = head.next; 
        count--; 
        return value; 
    }

    // Time complexity O(1)
    // Spatial complexity O(1)
    public void push(T val) {
        Node<T> newNode = new Node<>(val); 
        newNode.next = head; 
        head = newNode;
        count++;
    }

    // Time complexity O(1)
    // Spatial complexity O(1)
    public T peek() {
        if (head == null) { 
            return null;
        }
        return head.value;
    }

    // Exercise No.3 
    // result == null;
}



