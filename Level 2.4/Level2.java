public class Level2 {
    public static int artificial_muscle_fibers(int[] arr) {
        boolean[] digit= new boolean[32001];
        int count = 0;

        for (int num : arr) {
            if (!digit[num]) {
                digit[num] = true; 
            } else {
                count++; 
            }
        }
        return count;
    }
}