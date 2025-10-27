import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;

    private int step;

    public NativeDictionary(int sz, Class clazz)
    {
      size = sz;
      slots = new String[size];
      values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key)
    {
      int hashValue = Math.abs(key.hashCode()) % size;
      if(hashValue != 0) {
        return hashValue;
      }
      return 0;
    }

    public boolean isKey(String key)
    {
        int index = hashFun(key);
        
        for (; slots[index] != null; index = (index + 1) % size) {
            if (slots[index].equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void put(String key, T value)
    {
       int index = hashFun(key);
        
        for (; slots[index] != null; index = (index + 1) % size) {
            if (slots[index].equals(key)) {
                values[index] = value;
                return;
            }
        }
        slots[index] = key;
        values[index] = value;
    }

    public T get(String key)
    {
         int index = hashFun(key);
        for (; slots[index] != null; index = (index + 1) % size) {
            if (slots[index].equals(key)) {
                return values[index];
            }
        }
        return null;
    }
}



