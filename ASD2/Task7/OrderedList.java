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

    public OrderedList(boolean asc)
    {
      head = null;
      tail = null;
      _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
		if (v1 instanceof String && v2 instanceof String) {
           String str1 = ((String) v1).trim();
           String str2 = ((String) v2).trim();
           return str1.compareTo(str2);
       }
       if (v1 instanceof Comparable && v2 instanceof Comparable) {
           return ((Comparable<T>) v1).compareTo(v2);
       }
    }

    public void add(T value)
    {
           Node<T> newNode = new Node<>(value);

	    if (head == null) {
	        head = tail = newNode;
	        return;
	    }
	
	    Node<T> current = head;
	
	    if (compare(value, head.value) < 0) {
	        newNode.next = head;
	        head.prev = newNode;
	        head = newNode;
	        return;
	    }
	
	    while (current.next != null && compare(value, current.next.value) >= 0) {
	        current = current.next;
	    }
	
	    if (current.next == null) {
	        current.next = newNode;
	        newNode.prev = current;
	        tail = newNode;
	    } else { 
	        newNode.prev = current;
	        newNode.next = current.next;
	        current.next.prev = newNode;
	        current.next = newNode;
	    }
	}

	  
    public Node<T> find(T val)
    {
	    Node<T> current = head;
       while (current != null) {
           int comparison = compare(current.value, val);
           if (comparison == 0) {
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



