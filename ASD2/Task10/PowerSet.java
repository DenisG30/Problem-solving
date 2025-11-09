import java.util.Arrays;

public class PowerSet
{
    private String[] elements;
    private int size;

    public int step;
    private  int countElem;


    public PowerSet()
    {
        this.size = 20000;
        this.elements = new String[size];
        this.step = 1;
        countElem = 0;
    }


    public int customHashCode(String value) 
    {
        int hash = 0;
        for (int i = 0; i < value.length(); i++) {
            hash += value.charAt(i); 
        }
        return hash;
    }


    public int hashFun(String value) 
    {
        return (customHashCode(value) & 0x7FFFFFFF) % size; 
    }


    public int seekSlot(String value) 
    {
        int index = hashFun(value);
        int originalIndex = index;
        
        for (; elements[index] != null; index = (index + step) % size) {
            if (elements[index].compareTo(value) == 0) {
                return index; 
            }
            if (index == originalIndex) { 
                break;
            }
        }

        if (elements[index] == null) {
            return index;
        }
        return -1; 
    }


    public int size()
    {
        if(countElem > 0) {
            return countElem;
        }
        return 0;
    }


    public void put(String value)
    {
        if (countElem  == elements.length) {
            resize();
        }
       
        int slotIndex = seekSlot(value);
        
        if (slotIndex != -1 && elements[slotIndex] == null) { 
            elements[slotIndex] = value;
            countElem++;
        }
        
    }


    public boolean get(String value)
    {
        int index = hashFun(value);
        int originalIndex = index;
        
        for (; elements[index] != null; index = (index + step) % size) {
            if (elements[index].compareTo(value) == 0) {
                return true; 
            }

            if (index == originalIndex) { 
                break;
            }
        }
        return false;
    }


    public boolean remove(String value)
    {
        int index = hashFun(value);
        int originalIndex = index;

        for (; elements[index] != null; index = (index + step) % size) {
            if (elements[index].compareTo(value) == 0) {
                elements[index] =  null;
                countElem--;
                return true; 
            }

            if (index == originalIndex) { 
                break;
            }
        }
        return false;
    }


    public PowerSet intersection(PowerSet set2)
    {
        PowerSet result = new PowerSet();

        if (this.size() == 0 && set2.size() == 0 || this.size() != 0 && set2.size() == 0 || this.size() == 0 && set2.size() != 0) {
            return result;
        }

        for (int i = 0; i < size; i++) {
            if (elements[i] != null && set2.get(elements[i])) {
                result.put(elements[i]);
            }
        }
        if(result.size() != 0) {
            return result;
        }
        return null;
    }


    public PowerSet union(PowerSet set2)
    {
        if (set2 == null) {
            return null;
        }
        
        if (this.size() != 0 && set2.size() == 0) {
            return this;
        }

        if (this.size() == 0 && set2.size() != 0) {
            return set2;
        }

        if(this.size() == 0 && set2.size() == 0) {
            return this;
        }

        PowerSet result = new PowerSet();
        
        for (int i = 0; i < this.elements.length; i++) {
            if (elements[i] != null) {
                result.put(elements[i]);
            }
        }

        for (int i = 0; i < set2.elements.length; i++) {
            if (set2.elements[i] != null) {
                result.put(set2.elements[i]);
            }
        }
        
        if(result.size() != 0) {
            return result;
        }
        
        return null;
    }


    public PowerSet difference(PowerSet set2)
    {
        if (set2 == null || this.size() == 0 && set2.size() != 0) {
            return null;
        }
        
        if (this.size() == 0 && set2.size() == 0 || this.size() != 0 && set2.size() == 0) {
            return this;
        }
        
        PowerSet result = new PowerSet();

        for (int i = 0; i < this.elements.length; i++) {
            if (elements[i] != null && !set2.get(elements[i])) {
                result.put(elements[i]);
            }
        }
        if(result.size() != 0) {
            return result;
        }

        return null;
    }

    public boolean isSubset(PowerSet set2)
    {
        if (set2 == null || this.size() == 0 && set2.size() != 0 || this.size() < set2.size()) {
            return false;
        }
        
        if (this.size() == 0 && set2.size() == 0 || this.size() != 0 && set2.size() == 0) {
            return true;
        }

        boolean flag = true;

        for (int i = 0; i < set2.elements.length; i++) {
            if (set2.elements[i] != null && !this.get(set2.elements[i])) {
                flag = false;
                break;
            }
        }
            
        if(flag) {
            return true;
        }
        return false;
    }


    public boolean equals(PowerSet set2)
    {
        if(this.size != set2.size) {
            return false;
        }
        
        boolean flag = true;
        for (int i = 0; i < this.elements.length; i++) {

            if (this.elements[i] != null && !set2.get(elements[i])) {
                flag = false;
                break;
            }
        }
            
        if(flag) {
            return true;
        }
        return false;
    }

    private void resize() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}




