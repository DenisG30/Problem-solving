import java.util.*;

public class Deque<T>
{
    public Node head;
    public Node tail;


    public Deque()
    {
        head = null;
        tail = null;
     // инициализация внутреннего хранилища
    }

    public void addFront(T item)
    {
     // добавление в голову
        Node<T> newNode = new Node<>(item); 
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
            this.head.next = null;
            this.head.prev = null;
        } else {
            newNode.next = head;
            head.prev = newNode;
            this.head = newNode;
        }
    }

    public void addTail(T item)
    {
        Node<T> newNode = new Node<>(item); 
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = newNode;
            newNode.prev = tail;
        }
        this.tail = newNode;
    }

    public T removeFront()
    {
     // удаление из головы
     if(head != null) {
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
     }
     return null;
    }

    public T removeTail()
    {
     // удаление из хвоста
     return null;
    }
        
    public int size()
    {
     return 0; // размер очереди
    }
}

class Node<T>
{
     public T value;
     public Node next;
     public Node prev;

     public Node(T _value) 
     { 
       value = _value; 
       next = null;
       prev = null;
     }
}
