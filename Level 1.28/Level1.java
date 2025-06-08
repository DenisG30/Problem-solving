public class Level1 {
    public static String Keymaker(int k) {
        boolean[] doors = new boolean[k];

        for (int i = 1; i <= k; i++) {
            for (int j = i - 1; j < k; j += i) {
                doors[j] = !doors[j]; 
            }
        }
        StringBuilder res = new StringBuilder();
        for (boolean door : doors) {
            res.append(door ? '1' : '0');
        }

        return res.toString();
    }
}
