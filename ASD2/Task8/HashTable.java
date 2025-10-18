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
        int hash = 0;
        for (int i = 0; i < value.length(); i++) {
            hash += value.charAt(i); 
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



