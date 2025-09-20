// Exercise No.4 
public class Stack2 {
    public static boolean balanceSingle (String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch); 
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false; 
                }
                stack.pop(); 
            }
        }
        return stack.isEmpty();
    }

// Exercise No.5, Start.
    public static boolean balanceMultiple (String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false; 
                }
                char top = stack.pop();
                
                if (!matchPair(top, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean matchPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
// Exercise No.5, End.

}

// Exercise No.6
public class Stack1<T extends Comparable<T>> {
    private Node<T> head;
    private int count;
    private Node<T> minHead;

    // Exercise No.7
    private double sum;
    private double average;

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public Stack1() {
        head = null;
        minHead = null;
        count = 0;
        sum = 0.0;
        average = 0.0;
    }

    public int size() {
        return count;
    }

    public T pop() {
        if (head == null) {
            return null;
        }

        T value = head.value;
        head = head.next;
        count--;

        // Exercise No.7
        sum -= ((Number) value).doubleValue();
        updateAverage();

        if (value.equals(minHead.value)) {
            minHead = minHead.next;
        }
        return value;
    }

    public void push(T val) {
        Node<T> newNode = new Node<>(val);
        newNode.next = head;
        head = newNode;
        count++;

        // Exercise No.7
        sum += ((Number) val).doubleValue();
        updateAverage();

        if (minHead == null || val.compareTo(minHead.value) <= 0) {
            Node<T> newMinNode = new Node<>(val);
            newMinNode.next = minHead;
            minHead = newMinNode;
        }
    }

    public T peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    public T getMin() {
        if (minHead == null) {
            return null;
        }
        return minHead.value;
    }

    // Exercise No.7
    public double getAverage() {
        return count == 0 ? 0 : average;
    }

    private void updateAverage() {
        average = count == 0 ? 0 : sum / count;
    }
}

/* 
Exercise No.9. Reflection

Рекомендацию понял. В целом идея и была реализовать код таким образом.
Но использовал current = current.prev; 
Это может быть не сразу понятно, но логика понятна. 
*/


/* 
Exercise No.10. Reflection

Решение понятно. Решил погуглить и в следствии реализовать Алгоритм Флойда.
public boolean cycle() {
        HashSet<Node> nodesSeen = new HashSet<>();
        Node current = head;

        for (Node current = head; current != null; current = current.next) {
            if (nodesSeen.contains(current)) {
                return true; 
            }
            nodesSeen.addInTail(current);
        }

        return false;
    }
*/


/* 
Exercise No.11. Reflection

Согласен, реализация пузырьком была бы проще, чем сортировка реализованная мной.
Проще и в понимании. Я просчитался, посчитал, что реализация пузырьком имеет временную сложность выше.
*/

/* 
Exercise No.12. Reflection

Понятно. Для лучшей реализации необходимо использовать кучу.
*/

/* 
Exercise No.13. Reflection

Понятно. Буду стараться применять. Изучу подробнее на примерах. 
*/



