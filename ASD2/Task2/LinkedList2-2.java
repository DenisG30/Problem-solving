public class LinkedList2 {
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
    
// Exercise No.9* ("flips" the order of elements in a linked list, changing it to the opposite)
// Time complexity O(n)
// Spatial complexity O(1)
    public void reverse() 
    {
        Node current = head;
        Node temp = null;
        Node tempTail = null;

        while (current != null) {
            if (current.prev == null) {
                tempTail = tail;
                tail = head;
            }

            if (current.next == null) {
                head = tempTail;
            }

            temp = current.prev; 
            current.prev = current.next; 
            current.next = temp; 
            current = current.prev; 
        }
    }

// Exercise No.10* (Checking for cycles (self-looping) within a list)
// Time complexity O(n)
// Spatial complexity O(1)
    public boolean cycle() 
    {
        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false; 
    }

// Exercise No.11* (Method that sorts the list)
// Time complexity O(n)
// Spatial complexity O(1)

// Method for sorting a doubly linked list
    public void sortCompose() 
    {
        head = mergeSort(head);
        tail = getTail(head);
    }

    private Node mergeSort(Node head) 
    {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;

        middle.next = null;

        Node left = mergeSort(head); 
        Node right = mergeSort(nextOfMiddle); 
        
        return sortedMerge(left, right);
    }

    private Node sortedMerge(Node left, Node right) 
    {
        if (left == null) return right;
        if (right == null) return left;

        Node result;

        if (left.value <= right.value) {
            result = left;
            result.next = sortedMerge(left.next, right);
            result.next.prev = result; 
            result.prev = null;
        } else {
            result = right;
            result.next = sortedMerge(left, right.next);
            result.next.prev = result;
            result.prev = null;
        }
        return result;
    }

// Find the middle node of the list
    private Node getMiddle(Node head) 
    {
        if (head == null) return head;

        Node slow = head;
        Node fast = head.next;

    // Using two pointers: slow and fast, Floyd's algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node getTail(Node node) 
    {
        while (node != null && node.next != null) {
            node = node.next;
        }
        return node;
    }

    public LinkedList2 connectionLists(LinkedList2 list1, LinkedList2 list2) 
    {
        LinkedList2 nList = new LinkedList2();
        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.value <= current2.value) {
                nList.addInTail(new Node(current1.value));
                current1 = current1.next;
            } else {
                nList.addInTail(new Node(current2.value));
                current2 = current2.next;
            }
        }

        while (current1 != null) {
            nList.addInTail(new Node(current1.value));
            current1 = current1.next;
        }

        while (current2 != null) {
            nList.addInTail(new Node(current2.value));
            current2 = current2.next;
        }

        return nList;
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



