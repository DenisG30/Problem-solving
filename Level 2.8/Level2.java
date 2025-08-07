public class Level2 {
    public static String army_communication_matrix(int n, int[][] matrix) {
        int[][] matrixSum = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrixSum[i][j] = matrix[i - 1][j - 1] + matrixSum[i - 1][j] + matrixSum[i][j - 1] - matrixSum[i - 1][j - 1];
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int x = 0, y = 0, maxSize = 0;


        for (int m = 2; m <= n - 1; m++) { 
            for (int x1 = 0; x1 <= n - m; x1++) { 
                for (int y1 = 0; y1 <= n - m; y1++) { 
                    int x2 = x1 + m - 1; 
                    int y2 = y1 + m - 1; 

                    int sum = matrixSum[x2 + 1][y2 + 1] - matrixSum[x1][y2 + 1] - matrixSum[x2 + 1][y1] + matrixSum[x1][y1];

                    if (sum > maxSum) {
                        maxSum = sum;
                        x = x1;
                        y = y1;
                        maxSize = m;
                    }
                }
            }
        }

        return x + " " + y + " " + maxSize;
    }
}