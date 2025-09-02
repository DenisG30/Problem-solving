// Task 2. Bidirectional linked list

public class LinkedList2
{
     public Node head;
     public Node tail;

     public LinkedList2()
     {
       head = null;
       tail = null;
     }

     public void addInTail(Node _item)
     {
       if (head == null) {
        this.head = _item;
        this.head.next = null;
        this.head.prev = null;
       } else {
        this.tail.next = _item;
        _item.prev = tail;
       }
       this.tail = _item;
     }

// Exercise No.1 (Search for node by a specific value)
// Time complexity O(n)
// Spatial complexity O(1)
     public Node find(int _value)
     {
        Node current = head;
        while (current != null)
        {
            if (current.value == _value)
            {
                return current;
            }
            current = current.next; 
        }
        return null; 
     }

// Exercise No.2 (Search for all nodes by a specific value)
// Time complexity O(n)
// Spatial complexity O(n)
     public ArrayList<Node> findAll(int _value)
     {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node current = head;

        while (current != null)
        {
            if (current.value == _value)
            {
                nodes.add(current);
            }
            current = current.next;
        }
        
        return nodes;
     }

// Exercise No.3 (Deleting all nodes by its value)
// Time complexity O(n)
// Spatial complexity O(1)
     public boolean remove(int _value)
     {
        Node current = head;

        while (current != null) {
            if (current.value == _value) {
                if (current.prev == null) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    current.prev.next = current.next;
                }

                if (current.next == null) {
                    tail = current.prev;
                    if (tail != null) {
                        tail.next = null; 
                    }
                } else {
                    current.next.prev = current.prev; 
                }

                return true; 
            }
            current = current.next; 
        }
        return false; 
     }

// Exercise No.4 (Deleting all nodes by its value)
// Time complexity O(n)
// Spatial complexity O(1)
     public void removeAll(int _value)
     {
        Node current = head;

        while (current != null) {
            Node nextNode = current.next; 

            if (current.value == _value) {
                
                if (current.prev == null) {
                    head = current.next; 
                    if (head != null) {
                        head.prev = null; 
                    }
                } else {
                    current.prev.next = current.next; 
                }

                
                if (current.next == null) {
                    tail = current.prev; 
                    if (tail != null) {
                        tail.next = null; 
                    }
                } else {
                    current.next.prev = current.prev; 
                }
            }

            current = nextNode;
        }
     }

// Exercise No.7 (Clearing all content)
// Time complexity O(1)
// Spatial complexity O(1)
     public void clear()
     {
        head = null;
        tail = null;
     }

     public int count()
     {
        int count = 0;
        Node current = this.head;

        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
     }

// Exercise No.5,6 (Insert a new node before or after a specified node)
// Time complexity O(1)
// Spatial complexity O(1)
     public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
     {
        if (_nodeAfter == null) {
            
            _nodeToInsert.next = head;
            if (head != null) {
                head.prev = _nodeToInsert;
            }
            head = _nodeToInsert; 
            if (tail == null) {
                tail = _nodeToInsert; 
            }
        } else {
            _nodeToInsert.next = _nodeAfter.next; 
            _nodeToInsert.prev = _nodeAfter; 

            if (_nodeAfter.next != null) {
                _nodeAfter.next.prev = _nodeToInsert; 
            } else {
                tail = _nodeToInsert; 
            }

            _nodeAfter.next = _nodeToInsert; 
        } 
     }
}

class Node
{
     public int value;
     public Node next;
     public Node prev;

     public Node(int _value) 
     { 
       value = _value; 
       next = null;
       prev = null;
     }
}


