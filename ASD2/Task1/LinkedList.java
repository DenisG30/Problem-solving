import java.util.*;

public class LinkedList
{
     public Node head;
     public Node tail;

     public LinkedList()
     {
       head = null;
       tail = null;
     }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node current = this.head; 

    
        while (current != null) {
            if (current.value == _value) {
                nodes.add(current);
            }
            current = current.next; 
        }

        return nodes;
     }

     public boolean remove(int _value) {
        if (head == null) {
             return false;
        }

        if (head.value == _value) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.value == _value) {
                current.next = current.next.next;
                if (current.next == null) {
                    tail = current;
                }
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void removeAll(int _value) {
        while (head != null && head.value == _value) {
            head = head.next;
        }   

        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.value == _value) {
                if (previous != null) {
                    previous.next = current.next;
                }
            } else {
                previous = current;
            }
            current = current.next;
        }

        if (tail != null && tail.value == _value) {
            tail = previous;
        }
    }

     public void clear() {
        head = null;
        tail = null;
     }

     public int count() {
        int count = 0;
        Node current = this.head;

        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
     }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
            if (this.tail == null) {
                this.tail = _nodeToInsert;
            }
        } else {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;

            if (_nodeAfter == this.tail) {
                this.tail = _nodeToInsert;
            }
        }
    }

}

class Node
{
     public int value;
     public Node next;
     public Node(int _value) 
     {  
       value = _value;
       next = null;
     }
}



