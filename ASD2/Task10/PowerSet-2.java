import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

// Exercise No. 4
public class SimpleCartesianProduct {
    public static <T, U> Set<String> cartesianProduct(Set<T> setA, Set<U> setB) {
        Set<String> result = new HashSet<>();

        for (T a : setA) {
            for (U b : setB) {
                result.add("(" + a + ", " + b + ")");
            }
        }

        return result;
    }
}

// Exercise No. 5
public class SetIntersection {
    public static <T> Set<T> intersection(List<Set<T>> sets) {
        /*
        if (sets == null || sets.size() < 3) {
            throw new IllegalArgumentException("Должно быть передано три или более трех множеств.");
        }
        */

        Set<T> result = new HashSet<>(sets.get(0));

        for (int i = 1; i < sets.size(); i++) {
            result.retainAll(sets.get(i));
        }

        return result;
    }
}

// Exercise No. 6
public class Bag<T> {
    private Map<T, Integer> elements;

    public Bag() {
        elements = new HashMap<>();
    }

    public void add(T element) {
        elements.put(element, elements.getOrDefault(element, 0) + 1);
    }

    public boolean remove(T element) {
        if (elements.containsKey(element)) {
            int count = elements.get(element);
            if (count > 1) {
                elements.put(element, count - 1);
            } else {
                elements.remove(element);
            }
            return true;
        }
        return false;
    }

    public Map<T, Integer> getElementsWithFrequency() {
        return new HashMap<>(elements); 
    }
}

// Рефлексия 
/*
 Задание №3.
 Решение понятно. Таким образом я и старался реализовать, обращаясь к предыдущим задачам.

Задание №5.
Динамическую соль я реализовал плохо. ключи генерируются с помощью метода generateCollisionKey, 
который создает ключи в формате "a0", "a1", ..., "a99". 

Это приводит к тому, что ключи будут иметь одинаковый префикс, что может вызывать коллизии.

Хранение сущности с двумя полями: значение и соль тоже не реализовал. Не подумал об этом.
 */
