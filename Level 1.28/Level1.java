public class Level1 {
    public static String keymaker(int k) {
        boolean[] doors = new boolean[k];

        for (int i = 1; i <= k; i++) {
            for (int j = i - 1; j < k; j += i) {
                doors[j] = !doors[j]; 
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < doors.length; i++) {
            if (doors[i] == 1) {
                res.append('1'); 
            } else {
                res.append('0'); 
            }
        }

        return res.toString();
    }
}
