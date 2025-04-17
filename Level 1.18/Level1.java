public class Level1 {
    public static boolean MisterRobot(int N, int[] data) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (data[i] > data[j]) {
                    count++;
                }
            }
        }

        if(count % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
