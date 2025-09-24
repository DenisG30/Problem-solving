// Задание №5. Очередь.


// Задача №3. Вращение очереди по кругу на N элементов.
public class Queue2 {
    public T[] rotateQueue(T[] queue, int N){

        int quantityElem = queue.length;
        T[] newQueue = (T[]) new Object[quantityElem];

        N = N % quantityElem;

        if (N == 0 || quantityElem <= 1) {
           return queue; 
       }

        for(int i = 0; i < quantityElem; i++) {
            newQueue[(i + N) % quantityElem] = queue[i];
        }

        return newQueue;
    }
}

// Задача №4. Реализация очереди с помощью двух стеков.
class MyQueue {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void enqueue(int x) {
        inputStack.push(x);
    }


    public int dequeue() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }
    
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

// Задача №5. Обращение всех элементов в очереди в обратном порядке.
     public void reverse() {
        Stack<Integer> tempStack = new Stack<>();

        while (!inputStack.isEmpty()) {
            tempStack.push(inputStack.pop());
        }
    }
}

// Задача №6. Реализация круговой очереди
class CircularQueue {
    private int[] queue;       // Статический массив для хранения элементов очереди
    private int front;         // Указатель на начало очереди
    private int rear;          // Указатель на конец очереди
    private int size;          // Текущий размер очереди
    private int capacity;      // Ёмкость очереди

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public boolean enqueue(int value) {
        if (size == capacity) {  
            return false; 
        }
        queue[rear] = value; 
        rear = (rear + 1) % capacity; 
        size++; 
        return true;
    }

    public Integer dequeue() {
        if (size == 0) {
            return null; 
        }
        int value = queue[front]; 
        front = (front + 1) % capacity; 
        size--;
        return value;
    }
}

// Рефлексия. 
/* 
    Задача №6. Динамический массив на основе банковского метода.

    Суть ясна. Но как верно описать я не понял. Я посчитал, что реализация, 
    мной указанная и есть массив на основе банковского метода.

    //////
    
    Задача №7. Многомерный динамический массив.

    Понял. Согласен.
    
    Но более 3-х уровней многомерного массива непросто представить. 
    Реализовать проще, чем визуализировать.

    А вот дальше не совсем понятно. 
    
    Для примера сделал двумерный массив, дальше не стал. 
    Не понял как избавиться от вложенных циклов.

*/



