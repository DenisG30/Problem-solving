public class Level1 {
    public static boolean TransformTransform(int A[], int N) {
        int[] B = transform(A, N);
        int[] C = transform(B, B.length);
        int sum = 0;
        for (int value : C) {
            sum += value;
        }
        return sum % 2 == 0;
    }

    private static int[] transform(int[] A, int N) {
        int[] B = new int[N * (N + 1) / 2]; 
        int id = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - i - 1; j++) {
                int k = i + j;
                int max = A[j];
                for (int m = j; m <= k; m++) {
                    if (A[m] > max) {
                        max = A[m];
                    }
                }
                B[id++] = max;
            }
        }

        int[] res = new int[id];
        System.arraycopy(B, 0, res, 0, id);
        return res;
    }
}
