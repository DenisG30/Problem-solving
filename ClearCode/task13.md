#### Использование ArrayList

До:
```
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {}
    }
}
```

После:
```
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            arr.add(i);
        }
        for (int value : arr) {
        }
    }
}
```
---

#### Использование Stack

До:
```
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add(i);
        }

        for (int i = arr.size() - 1; i >= 0; i--) {
         //...
        }
    }
}
```

После:
```
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        for (int i = stack.size() - 1; i >= 0; i--){
        //код...
        }
    }
}
```
___


#### Использование очереди

До:
```
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add(i);
        }

        for (int i = arr.size() - 1; i >= 0; i--){
        //...
        }
    }
}
```

После:
```
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }

        for (int i = stack.size() - 1; i >= 0; i--){
            System.out.println(queue.poll());
        }
    }
}
```
___

#### Использование множества 

До:
```
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2};
        ArrayList<Integer> uniqueElements = new ArrayList<>();
        
        for (int value : arr) {
            if (!uniqueElements.contains(value)) {
                uniqueElements.add(value);
            }
        }
        // код...
    }
}
```

После:
```

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2};
        Set<Integer> uniqueElements = new HashSet<>();
        
        for (int value : arr) {
            uniqueElements.add(value);
        }
        
        // код...
    }
}
```
___


#### Использование словаря

До:
```

public class Main {
    public static void main(String[] args) {
        String[] keys = {"a", "b", "c"};
        int[] values = {1, 2, 3};
        
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < keys.length; i++) {
            arr.add(keys[i] + ": " + values[i]);
        }

        for (String entry : arr) {
            System.out.println(entry);
        }
    }
}
```

После:
```
public class Main {
    public static void main(String[] args) {
        Map<String, Integer> data = new HashMap<>();
        data.put("a", 1);
        data.put("b", 2);
        data.put("c", 3);

        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
```
___

