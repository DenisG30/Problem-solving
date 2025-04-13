public class Level1 {
    public static int MaximumDiscount(int N, int[] price) {
        
        if (N < 3) {
            return 0;
        }

        int discount = N / 3;
        int resOne = 0;
        int resTwo = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (price[j] < price[j + 1]) { 
                    int temp = price[j];
                    price[j] = price[j + 1];
                    price[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if((i + 1) % 3 == 0) {
                resOne += price[i];
            }
        }

        for(int i = N - 1; i > N - 1 - discount; i-- ) {
            resTwo += price[i];
        }
        if(resOne >= resTwo) {
            return resOne;
        } else {
            return resTwo;
        }
    }
}
