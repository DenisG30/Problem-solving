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
		int comparison = 0;
        if (v1 instanceof String && v2 instanceof String) {
            String str1 = ((String) v1).trim(); 
            String str2 = ((String) v2).trim();
            comparison = str1.compareTo(str2);
        }
        comparison = v1.compareTo(v2);
		
        if(comparison != 0) {
			return comparison;
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

    public void removeDuplicates() {
      if (head == null) {
          return; 
      }
  
      Node<T> current = head;
  
      while (current != null && current.next != null) {
          if (compare(current.value, current.next.value) == 0) {
              Node<T> duplicateNode = current.next;
              current.next = duplicateNode.next;
  
              if (duplicateNode.next != null) {
                  duplicateNode.next.prev = current; 
              } else {
                  tail = current; 
              }
          } else {
              current = current.next; 
          }
      }
  }

public boolean containsSublist(OrderedList<T> sublist) {
    if (sublist.isEmpty()) {
        return true; 
    }
    
    Node<T> current = this.head;
    
    while (current != null) {
        if (matchesAt(current, sublist.head)) {
            return true; 
        }
        current = current.next; 
    }
    return false;
}

private boolean matchesAt(Node<T> start, Node<T> sublistHead) {
    Node<T> current1 = start;
    Node<T> current2 = sublistHead;

    while (current2 != null) {
        if (current1 == null || !current1.value.equals(current2.value)) {
            return false;
        }
        current1 = current1.next;
        current2 = current2.next;
    }
    return true;
}

public T findMostFrequent() {
        if (head == null) {
            return null; 
        }

        Map<T, Integer> frequencyMap = new HashMap<>();
        Node<T> current = head;

        while (current != null) {
            frequencyMap.put(current.value, frequencyMap.getOrDefault(current.value, 0) + 1);
            current = current.next;
        }

        T mostFrequentValue = null;
        int maxFrequency = 0;

        for (Map.Entry<T, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequentValue = entry.getKey();
            }
        }

        return mostFrequentValue; 
    }

    class SkipListNode<T> {
    T value;
    SkipListNode<T>[] forward;

    SkipListNode(int level, T value) {
        this.value = value;
        forward = new SkipListNode[level + 1];
    }
}

class SkipList<T extends Comparable<T>> {
    private static final int MAX_LEVEL = 16; 
    private SkipListNode<T> header;
    private int level;
    private Random random;

    public SkipList() {
        header = new SkipListNode<>(MAX_LEVEL, null);
        level = 0;
        random = new Random();
    }

    public void insert(T value) {
        SkipListNode<T>[] update = new SkipListNode[MAX_LEVEL + 1];
        SkipListNode<T> current = header;

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value.compareTo(value) < 0) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        current = current.forward[0];

        if (current == null || !current.value.equals(value)) {
            int newLevel = randomLevel();
            if (newLevel > level) {
                for (int i = level + 1; i <= newLevel; i++) {
                    update[i] = header;
                }
              level = newLevel;
            }

            SkipListNode<T> newNode = new SkipListNode<>(newLevel, value);
            for (int i = 0; i <= newLevel; i++) {
                newNode.forward[i] = update[i].forward[i];
                update[i].forward[i] = newNode;
            }
        }
    }

    public int indexOf(T value) {
        SkipListNode<T> current = header;

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value.compareTo(value) < 0) {
                current = current.forward[i];
            }
        }

        current = current.forward[0];
        if (current != null && current.value.equals(value)) {
            return getIndex(current);
        }
        return -1; 
    }

    private int randomLevel() {
        int lvl = 0;
        while (lvl < MAX_LEVEL && random.nextBoolean()) {
            lvl++;
        }
        return lvl;
    }

    private int getIndex(SkipListNode<T> node) {
        return -1; 
    }
}
	  
// Рефлексия. 
/* 
    Задача №3. Вращение очереди по кругу на N элементов.
    Решение понятно. Но при условии использования массива для очереди временная сложность будет О(N). 
	Но если бы использовали связный список, то уложилось бы в O(n*N)
    
    Задача №4. Очередь с помощью двух стеков.
    Решение аналогично рекомендации.
    
    Задача №5. Обращение всех элементов в очереди в обратном порядке.
	Решение аналогично рекомендации.

	Задача №6. Циклическая буферную очередь на базе статического массива фиксированного размера.
	Решение аналогично рекомендации. Но не учёл несколько условий.
	"Если tail "догоняет" head, это означает, что очередь заполнена, и добавление нового элемента невозможно."
	"Если head и tail совпадают после удаления, это означает, что очередь пуста."
	Не продумал эти варианты.
	
	"Очередь пуста, если head == tail."
	"Очередь заполнена, если (tail + 1) % размер_массива == head."
	В своем решение я добавил переменные с количеством элементов в массиве и ёмкостью массива. Из-за этого не продумал такую логику.
*/


