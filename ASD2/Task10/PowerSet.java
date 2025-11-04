import java.util.Arrays;

public class PowerSet
{
    private String[] elements;
    private int size;

    public PowerSet()
    {
        // ваша реализация хранилища
        this.elements = new String[20000]; // Начальный размер массива
        this.size = 0;
    }

    public int size()
    {
            // количество элементов в множестве
            if(size != 0) {
                return size;
            }
            return 0;
    }


    public void put(String value)
    {
        // всегда срабатывает
        if (get(value)) {
            return; // Если элемент уже существует, выходим из метода
        }

        if (size == elements.length) {
            resize(); // Увеличиваем размер массива, если он полон
        }

        elements[size] = value; // Добавляем новый элемент
        size++;
    }

    public boolean get(String value)
    {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(String value)
    {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(value)) {
                elements[i] = elements[size - 1];
                elements[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        // пересечение текущего множества и set2
        PowerSet result = new PowerSet();
        for (int i = 0; i < size; i++) {
            if (set2.get(elements[i])) {
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
        // объединение текущего множества и set2
        if(set2 != null || this.size() != 0 && set2.size() != 0) {
            PowerSet result = new PowerSet();
            for (int i = 0; i < size; i++) {
                result.put(elements[i]);
            }
            for (int i = 0; i < set2.size(); i++) {
                result.put(set2.elements[i]);
            }
            return result;
        }
        return null;
    }

    public PowerSet difference(PowerSet set2)
    {
        // разница текущего множества и set2
        if(set2 != null || this.size() != 0) {
            PowerSet result = new PowerSet();
            for (int i = 0; i < size; i++) {
                if (!set2.get(elements[i])) {
                    result.put(elements[i]);
                }
            }
            return result;
        }
        return null;
    }

        public boolean isSubset(PowerSet set2)
        {
            if(set2 == null || this.size() == 0 && set2.size() == 0 && this.size() >= set2.size()) {
                return false;
            }

            boolean flag = false;
            for (int i = 0; i < size; i++) {
                flag = false;
                if (set2.get(elements[i])) {
                    flag = true;
                }
            }
            
            if(flag) {
                return true;
            }
            
                // возвращает true, если set2 есть
                // подмножество текущего множества,
                // иначе false
            return false;
        }

    public boolean equals(PowerSet set2)
    {
        if(this.size != set2.size) {
            return false;
        }
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            flag = false;
            if (set2.get(elements[i])) {
                flag = true;
            }
        }

        if(flag) {
            return true;
        }

        // возвращает true, 
        // если set2 равно текущему множеству,
        // иначе false
        return false;
    }

    private void resize() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

}
