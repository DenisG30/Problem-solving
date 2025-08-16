public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
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

    public int count() {
        int count = 0;
        Node current = this.head;

        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public LinkedList sum(LinkedList other) {

        LinkedList result = new LinkedList();
        Node current1 = this.head;
        Node current2 = other.head;

        while (current1 != null) {
            int sumValue = current1.value + current2.value;
            result.addInTail(new Node(sumValue));
            current1 = current1.next;
            current2 = current2.next;
        }

        return result;
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}


