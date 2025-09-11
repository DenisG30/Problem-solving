public class DynArray<T>
{
     public T [] array;
     public int count;
     public int capacity;
     Class clazz;

     public DynArray(Class clz)
     {
       clazz = clz; // нужен для безопасного приведения типов
       // new DynArray<Integer>(Integer.class);

       count = 0;
       makeArray(16);
     }

// Exercise No.1 (Formation of a memory block)
// Time complexity O(n)
// Spatial complexity O(n)
     public void makeArray(int new_capacity)
     {
        // array = (T[]) Array.newInstance(this.clazz, new_capacity);

        T[] newArray = (T[]) Array.newInstance(this.clazz, new_capacity);
        
        for (int i = 0; i < count; i++) {
            newArray[i] = array[i];
        }
        
        array = newArray;
        capacity = new_capacity;
     }

// Exercise No.1 (Getting an object by its index)
// Time complexity O(1)
// Spatial complexity O(1)
     public T getItem(int index)
     {
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException(index + " Going beyond borders " + (count - 1));
        }
        return array[index];
     }

// Exercise No.1 (Adding a new element to the end of the array)
// Time complexity O(n)
// Spatial complexity O(1)
     public void append(T itm)
     {
        if (count >= capacity) {
            makeArray(capacity * 2);
        }

        array[count] = itm;
        count++;
     }
     

// Exercise No.2 (Location in the i-th position of the object)
// Time complexity O(n)
// Spatial complexity O(1)
     public void insert(T itm, int index)
     {
        if (index < 0 || index > count) {
            throw new ArrayIndexOutOfBoundsException(index + " Going beyond borders " + count);
        }

        if (count == capacity) {
            makeArray(capacity * 2); 
        }

        for (int i = count; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = itm;
        count++;
     }

// Exercise No.3 (Deleting an object from the i-th position)
// Time complexity O(n)
// Spatial complexity O(1)
     public void remove(int index)
     {
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException(index + " Going beyond borders " + (count - 1));
        }

        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }

        count--;

        array[count] = null;

        if (count > 0 && count == capacity / 4) {
            makeArray(capacity / 2);
        }
     }
}

public class MultiDimArray<T> {
    private DynArray<DynArray<T>> dimensions;
    // Data_type[dimension1][dimension2][]..[dimensionN] array_name = new data_type[size1][size2]….[sizeN];
    public MultiDimArray(Class<T> clazz, int... sizes) {
        dimensions = new DynArray<>(DynArray.class);
        for (int size : sizes) {
            DynArray<T> dim = new DynArray<>(clazz);
            for (int i = 0; i < size; i++) {
                dim.append(null); // Инициализируем с null
            }
            dimensions.append(dim);
        }
    }

}
