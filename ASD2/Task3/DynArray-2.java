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

     public T getItem(int index)
     {
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException(index + " Going beyond borders " + (count - 1));
        }
        return array[index];
     }

     public void append(T itm)
     {
        if (count >= capacity) {
            makeArray(capacity * 2);
        }

        array[count] = itm;
        count++;
     }
     
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

//Рефлексия по заданию №8 "Функция суммирования двух связанных списков" :
/*
Действительно, не проверил, какой код залил в гит. Я понимаю, что списки для сложения должны быть равны и на "бумаге" это учитывал. 
Но не указал это в коде. Даже в тестах не проверил случай, когда количество элементов могут быть различны. Решение понятно. Буду внимательнее. 
*/
