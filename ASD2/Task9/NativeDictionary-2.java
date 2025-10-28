// Exercise No.5

class OrderedDictionary<K extends Comparable<K>, V> {
    private List<Entry<K, V>> entries;

    public OrderedDictionary() {
        entries = new ArrayList<>();
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
        Entry<K, V> newEntry = new Entry<>(key, value);
        int index = findIndex(key);
        
        if (index < entries.size() && entries.get(index).key.equals(key)) {
            entries.set(index, newEntry);
        } else {
            entries.add(index, newEntry);
        }
    }

    public V get(K key) {
        int index = findIndex(key);
        if (index < entries.size() && entries.get(index).key.equals(key)) {
            return entries.get(index).value;
        }
        return null;
    }

    public boolean isKey(K key) {
        int index = findIndex(key);
        return index < entries.size() && entries.get(index).key.equals(key);
    }

    public void remove(K key) {
        int index = findIndex(key);
        if (index < entries.size() && entries.get(index).key.equals(key)) {
            entries.remove(index);
        }
    }

    private int findIndex(K key) {
        int low = 0;
        int high = entries.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = entries.get(mid).key.compareTo(key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}


// Exercise No.6

class BitStringDictionary<V> {
    private Map<Integer, V> map;
    private int bitLength;

    public BitStringDictionary(int bitLength) {
        this.map = new HashMap<>();
        this.bitLength = bitLength;
    }

    private int bitStringToInt(String bitString) {
        if (bitString.length() != bitLength) {
            throw new IllegalArgumentException("Bit string must have length " + bitLength);
        }
        return Integer.parseUnsignedInt(bitString, 2);
    }

    public void put(String key, V value) {
        int intKey = bitStringToInt(key);
        map.put(intKey, value);
    }

    public V get(String key) {
        int intKey = bitStringToInt(key);
        return map.get(intKey);
    }

    public boolean containsKey(String key) {
        int intKey = bitStringToInt(key);
        return map.containsKey(intKey);
    }

    public void remove(String key) {
        int intKey = bitStringToInt(key);
        map.remove(intKey);
    }
    
    public String[] getKeys() {
        return map.keySet().stream()
                .map(Integer::toBinaryString)
                .map(bin -> String.format("%" + bitLength + "s", bin).replace(' ', '0')) 
                .toArray(String[]::new);
    }
}

// Рефлексия. 
/* 
    Задача №9. 
    Не добавил свой код на гитхаб.

    public OrderedList<T> merge(OrderedList<T> other) {
    OrderedList<T> mergedList = new OrderedList<>(this._ascending);
    
    Node<T> current1 = this.head;
    Node<T> current2 = other.head;

    while (current1 != null && current2 != null) {
        if (compare(current1.value, current2.value) <= 0) {
            mergedList.add(current1.value);
            current1 = current1.next;
        } else {
            mergedList.add(current2.value);
            current2 = current2.next;
        }
    }

    while (current1 != null) {
        mergedList.add(current1.value);
        current1 = current1.next;
    }

    while (current2 != null) {
        mergedList.add(current2.value);
        current2 = current2.next;
    }

    return mergedList;
}
    
    Задача №10. 
    Решение аналогично рекомендации. Но не проверил совпадают ли длины списков.
    

	Задача №11. 
	Решение из рекомендации понятно. Его использование было бы проще. Действительно, не было необходимости использовать Map в данной задаче.
    
    Задача №12.
    Решение из рекомендации понятно. Не подумал про бинарный поиск. Было бы проще.
*/



