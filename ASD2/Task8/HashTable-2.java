// Exercise No.3

public class DynamicHashTable<K, V> {
    private LinkedList<Entry<K, V>>[] table;
    private int size;
    private int capacity;
    private static final double LOAD_FACTOR = 0.75;

    public DynamicHashTable() {
        this.capacity = 16; 
        this.table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
        this.size = 0;
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        if ((double) size / capacity >= LOAD_FACTOR) {
            resize();
        }
        int index = getIndex(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; 
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return;
            }
        }
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    private void resize() {
        capacity *= 2; 
        LinkedList<Entry<K, V>>[] newTable = new LinkedList[capacity];
        
        for (int i = 0; i < capacity; i++) {
            newTable[i] = new LinkedList<>();
        }

        for (LinkedList<Entry<K, V>> bucket : table) {
            for (Entry<K, V> entry : bucket) {
                int newIndex = Math.abs(entry.key.hashCode()) % capacity;
                newTable[newIndex].add(entry);
            }
        }

        table = newTable;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}


// Exercise No.4 

public class MultiHashTable<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private LinkedList<Entry<K, V>>[] table;
    private int size;

    public MultiHashTable() {
        table = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hash1(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    private int hash2(K key) {
        return (Math.abs(key.hashCode()) / table.length) % table.length;
    }

    public void put(K key, V value) {
        if (size >= LOAD_FACTOR * table.length) {
            resize();
        }
        
        int index1 = hash1(key);
        int index2 = hash2(key);

        for (Entry<K, V> entry : table[index1]) {
            if (entry.key.equals(key)) {
                entry.value = value; 
                return;
            }
        }
        
        for (Entry<K, V> entry : table[index2]) {
            if (entry.key.equals(key)) {
                entry.value = value; 
                return;
            }
        }

        table[index1].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index1 = hash1(key);
        int index2 = hash2(key);

        for (Entry<K, V> entry : table[index1]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        for (Entry<K, V> entry : table[index2]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null; 
    }

    private void resize() {
        LinkedList<Entry<K, V>>[] oldTable = table;
        table = new LinkedList[oldTable.length * 2];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
        
        size = 0;
        for (LinkedList<Entry<K, V>> bucket : oldTable) {
            for (Entry<K, V> entry : bucket) {
                put(entry.key, entry.value);
            }
        }
    }

    public int size() {
        return size;
    }
}

// Exercise No.6
 
public class DDoSTest {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10, 1); // Создаем хэш-таблицу размером 10

        for (int i = 0; i < 100; i++) {
            String key = generateCollisionKey(i);
            hashTable.put(key);
            System.out.println("Inserted: " + key);
        }

        for (int i = 0; i < hashTable.size; i++) {
            System.out.println("Slot " + i + ": " + hashTable.slots[i]);
        }
    }

    private static String generateCollisionKey(int index) {
        return "a" + index;
    }
}


public class HashTable {
    public int size;
    public int step; 
    public String[] slots; 

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) slots[i] = null; 
    }

    public int customHashCode(String value) {
        int hash = 7;
        for (int i = 0; i < value.length(); i++) {
            hash = hash * 31 + value.charAt(i);
        }
        return hash;
    }

    public int hashFun(String value) {
        return (customHashCode(value) & 0x7FFFFFFF) % size; 
    }

    public int seekSlot(String value) {
        int index = hashFun(value);
        int originalIndex = index;

        while (slots[index] != null) {
            if (slots[index].equals(value)) {
                return index; 
            }
            index = (index + step) % size; 
            if (index == originalIndex) { 
                break;
            }
        }

        if (slots[index] == null) {
            return index;
        }
        
        return -1; 
    }

    public int put(String value) {
        int slotIndex = seekSlot(value);
       
        if (slotIndex != -1 && slots[slotIndex] == null) { 
            slots[slotIndex] = value;
            return slotIndex;
        }
        
        return -1;
    }

    public int find(String value) {
        int index = hashFun(value);
        int originalIndex = index;

        while (slots[index] != null) {
            if (slots[index].equals(value)) {
                return index;
            }
            index = (index + step) % size;
            if (index == originalIndex) {
                break;
            }
        }
        return -1;
    }
}


// Рефлексия. 
/* 
    Задача №4. Проверка строки на палиндром.
    Решение аналогично рекомендации. 
    Использовал функции удаления первого и последнего элемента. 
    При этом сравнивая их на неравенство. Если не равны, значит результат false.
    
    Задача №5. Минимальный элемент деки за O(1).
    Решение аналогично рекомендации. Но я не обработал условие:
    "если удаляемый элемент равен первому элементу дополнительной деки, то удаляем его и из дополнительной деки."

	Задача №6. Двусторонняя очередь на базе динамического массива.
	Я посчитал необходимым реализовать заполнение динамического массива из центра с помощью заранее известных индексов.
    Но как использовать очередь в массиве не понял.
*/
