public class Deque<T>
{
    public Node head;
    public Node tail;
    int count = 0;


    public Deque()
    {
        head = null;
        tail = null;
    }

    public void addFront(T item)
    {
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
        count++;
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
        count++;
    }

    public T removeFront()
    {
        if(count > 0) {
            T value = head.value;
        
            if(count == 1) {
                head = tail = null;
                
            } else {
                head = head.next;
                head.prev = null;
            }
            count--;
            return value; 
        }

        return null;

        
    }

    public T removeTail()
    {
        if(count > 0) {
            T value = tail.value;
        
            if(count == 1) {
                tail = head = null;           
            } else {
                tail = tail.prev;
                tail.next = null;     
            }
            count--;
            return value;
        }

        return null;
        
    }
        
    public int size()
    {
        if(count > 0) {
            return count;
        }
        return 0;
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



