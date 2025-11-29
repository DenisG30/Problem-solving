import java.util.Arrays;

class NativeCache<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int[] hits;

    public NativeCache(int capacity) {
        this.size = capacity;
        this.slots = new String[size];
        this.values = (T[]) new Object[size];
        this.hits = new int[size];
    }

    public int hash(String key) {
        return Math.abs(key.hashCode()) % size;
    }

    public void put(String key, T value) {
        int index = hash(key);
        for (int i = 0; i < size; i++) {
            int tryIndex = (index + i) % size;
            if (slots[tryIndex] == null || slots[tryIndex].equals(key)) {
                slots[tryIndex] = key;
                values[tryIndex] = value;
                hits[tryIndex]++;
                return;
            }
        }
        int minHitsIndex = 0;
        for (int i = 1; i < size; i++) {
            if (hits[i] < hits[minHitsIndex]) {
                minHitsIndex = i;
            }
        }
        slots[minHitsIndex] = key;
        values[minHitsIndex] = value;
        hits[minHitsIndex] = 1;
    }

    public T get(String key) {
        int index = hash(key);
        for (int i = 0; i < size; i++) {
            int tryIndex = (index + i) % size;
            if (slots[tryIndex] != null && slots[tryIndex].equals(key)) {
                hits[tryIndex]++;
                return values[tryIndex];
            }
            if (slots[tryIndex] == null) {
                break;
            }
        }
        return null;
    }

    public void remove(String key) {
        int index = hash(key);
        for (int i = 0; i < size; i++) {
            int tryIndex = (index + i) % size;
            if (slots[tryIndex] != null && slots[tryIndex].equals(key)) {
                slots[tryIndex] = null;
                values[tryIndex] = null;
                hits[tryIndex] = 0;
                return;
            }
            if (slots[tryIndex] == null) {
                break;
            }
        }
    }
}
