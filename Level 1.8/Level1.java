public class Level1 {
    public static int SumOfThe(int N, int [] data) {
        int res = 0;

        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(int j = 0; j < N; j++){
                if(j != i) {
                    sum += data[j];
                } else {
                    sum += 0;
                }
            }
            if(sum == data[i]) {
                res = data[i];
                break;
            }
            
        }

        return res;
    }
}
