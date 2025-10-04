import java.util.*;


 class Node<T>
  {
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
      value = _value;
      next = null;
      prev = null;
    }
  }

 public class OrderedList<T>
  {
    public Node<T> head, tail;
    private boolean _ascending;
    int count = 0;

    public OrderedList(boolean asc)
    {
      head = null;
      tail = null;
      _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
        int comparison = v1.compareTo(v2);
		if (comparison > 0) {
         	return 1;}
         else if (comparison < 0) {
         	return -1;
         }
        return 0;
      // -1 если v1 < v2
      // 0 если v1 == v2
      // +1 если v1 > v2
    }

    public void add(T value)
    {
           Node<T> newNode = new Node<>(value);
    
	    if (head == null) {
	        head = tail = newNode; 
	        return;
	    }

    	Node<T> current = head;
   
	    while (current != null) {
	        if (compare(value, current.value) < 0)
	            if (current.prev == null) {
	                newNode.next = head;
	                head.prev = newNode;
	                head = newNode;
	            } else { 
	                newNode.prev = current.prev;
	                newNode.next = current;
	                current.prev.next = newNode;
	                current.prev = newNode;
	            }
	            
	            return;
	        }
	        current = current.next;
	    }
	    
	    tail.next = newNode;
	    newNode.prev = tail;
	    tail = newNode;
    

    public Node<T> find(T val)
    {
        Node<T> current = head;
        while (current != null) {
            if (compare(current.value, val) == 0) {
                return current; 
            }
            current = current.next;
        }
        return null;
    }

    public void delete(T val)
    {
    	Node<T> nodeToDelete = find(val);
    	
        if (nodeToDelete == null) {
        	return;
        }

        if (nodeToDelete.prev != null) {
            nodeToDelete.prev.next = nodeToDelete.next; 
        } else {
            head = nodeToDelete.next;
        }

        if (nodeToDelete.next != null) {
            nodeToDelete.next.prev = nodeToDelete.prev;
        } else {
            tail = nodeToDelete.prev;
        }
    }

    public void clear(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int count()
    {
        int count = 0;
    	Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        
        if (count > 0) {
        	return count;
        }
       return 0;
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного 
                           // списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
  }
