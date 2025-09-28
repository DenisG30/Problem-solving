public class Deque2 {
    // Exercise No.4 
    public static boolean isPalindrome(String str) {
        Deque<Character> deque = new LinkedList<>();

        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false; 
            }
        }

        return true; 
    }


    // Exercise No.5
    private Deque<Integer> deque;
    private Deque<Integer> minDeque;

    public Deque2() {
        this.deque = new LinkedList<>();
        this.minDeque = new LinkedList<>();
    }

    public void add(int value) {
        deque.addLast(value);
        
        while (!minDeque.isEmpty() && minDeque.peekLast() > value) {
            minDeque.removeLast();
        }
        minDeque.addLast(value);
    }

    public int getMin() {
        if (!minDeque.isEmpty()) {
            return minDeque.peekFirst();
        }
        
    }
    
}

// Exercise No.6
class DequeArr<T> {
    private T[] array;
    private int front;
    private int rear; 
    private int size;  
    private int capacity = 16;

    
    public DequeArr() {
        array = (T[]) new Object[capacity];
        front = capacity / 2;
        rear = front; 
        size = 0;
    }

    public void addFront(T item) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        front--;
        array[front] = item;
        size++;
    }

    public void addTail(T item) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        array[rear] = item;
        rear++;
        size++;
    }

    public T removeFront() {
        T item = array[front];
        array[front] = null;
        front++;
        size--;
        
        if (size > 0 && size == array.length / 2) {
            resize((int)((double)array.length / 1.5));
        }
        
        return item;
    }

    public T removeTail() {
        rear--;
        T item = array[rear];
        array[rear] = null;
        size--;
        
        if (size > 0 && size == array.length / 2) {
            resize((int)((double)array.length / 1.5));
        }
        
        return item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        
        for (int i = 0; i < size; i++) {
            newArray[i] = array[front + i];
        }
        
        front = 0; 
        rear = size; 
        array = newArray; 
    }
}


/* Рефлексия:

Задача 4 и 5:
Решение совпадает с рекомендациями. 
По поводу словаря понятно. 
Но не избавился от вложенных условных конструкций.
 
Задача 6:
Решение понятно.

Задача 7:
Понял. Решение совпадает с рекомендацией.

Задача8:
Решение понятно.
 */



