import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
    
public class QueueTest {
    private Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }
        
    @Test
    void testEnqueueAndSize() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());
    }

    @Test
    void testDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals(3, queue.dequeue());
        assertNull(queue.dequeue()); // Очередь теперь пустая
    }

    @Test
    void testDequeueEmptyQueue() {
        assertNull(queue.dequeue()); // Декью из пустой очереди
    }

    @Test
    void testCapacityIncrease() {
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
        assertEquals(20, queue.size());
    }

     @Test
    void testCapacityDecrease() {
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
        
        for (int i = 0; i < 15; i++) {
            queue.dequeue();
        }

        assertEquals(5, queue.size());
    }
}





