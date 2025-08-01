public class Level2{
    public static int[] TRC_sort(int[] trc) {
        int low = 0;
        int mid = 0; 
        int high = trc.length - 1; 

        for (; mid <= high;) { 
            if (trc[mid] == 0) {
               
                int temp = trc[low];
                trc[low] = trc[mid];
                trc[mid] = temp;
                
                low++;
                mid++;
            } else if (trc[mid] == 1) {
                mid++;
            } else { 
                int temp = trc[mid];
                trc[mid] = trc[high];
                trc[high] = temp;
                
                high--;
            }
        }
    return trc;
    }
}