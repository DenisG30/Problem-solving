public class Queue<T>
{
    private T[] queue; 
    private int endId; 
    private int capacity; 
    
      public Queue()
      {
        capacity = 16; 
        queue = (T[]) new Object[capacity]; 
        endId = -1; 
      } 

    // Time complexity O(1)
    // Spatial complexity O(n)
      public void enqueue(T item)
      {
        if (endId + 1 == capacity) { 
            makeQueue(capacity *= 2);
        }
        queue[++endId] = item; 
      }

    // Time complexity O(n)
    // Spatial complexity O(n)
      public T dequeue()
      {
        if(endId > -1){
            T temp = queue[0];

            for (int i = 0; i < endId; i++) {
                queue[i] = queue[i + 1];
            }

            queue[endId] = null;
            endId--;

            if ((double) capacity / (endId + 1) > 2.0) {
                reducedCapacity(capacity);
            }
            return temp;
        }
        return null; 
      }

      public int size()
      {
        if(endId > -1) {
            return endId + 1;
        }
        return 0; 
      }


      public void makeQueue(int new_capacity)
     {
        T[] newQueue = (T[]) new Object[new_capacity]; 

        if (queue != null) {
            for (int i = 0; i < endId + 1; i++) {
                newQueue[i] = queue[i];
            }
        }
        queue = newQueue;
        capacity = new_capacity;
     }
     
     public void reducedCapacity(int new_capacity)
     {
        if((int)((double)capacity / 1.5) < 16 ) {
                    makeQueue(16);
                } else {
                makeQueue((int)((double)capacity / 1.5));
                }
     }
}





