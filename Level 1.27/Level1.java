public class Level1 {
    public static boolean Football(int F[], int N) {
        int[] newArr = new int[N];
        for (int i = 0; i < N; i++) {
            newArr[i] = F[i];
        }

        int n = newArr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (newArr[j] > newArr[j + 1]) {
                    int temp = newArr[j];
                    newArr[j] = newArr[j + 1];
                    newArr[j + 1] = temp;
                }
            }
        }

        int quanElem = 0;
        for (int i = 0; i < N; i++) {
            if (F[i] != newArr[i]) {
                quanElem++;
            }
        }

        if (quanElem == 0) {
            return false;
        }

        if (quanElem == 2) {
            return true;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                
                int[] reversArr = new int[N];
                for (int k = 0; k < N; k++) {
                    reversArr[k] = F[k];
                }
                
                for (; i < j; i++, j--) {
                    int temp = reversArr[i];
                    reversArr[i] = reversArr[j];
                    reversArr[j] = temp;
                    
                }
                
                
                for (int q = 1; q < reversArr.length; q++) {
                    if (reversArr[q] < reversArr[q - 1]) {
                        return false;
                    }
                }
                return true;
            }
        }

        return false;
    }
}
