public class Level2 {
    public static int[] matrix(int n, int m, int[][] matrix) {
        int[] result = new int[m * n];
        int left = 0, right = n - 1;
        int top = 0, bottom = m - 1;
        int index = 0;
        int elements = m * n; 

        for (int count = 0; count < elements; ) {
            
            for (int i = left; i <= right && count < elements; i++) {
                result[index++] = matrix[top][i];
                count++;
            }
            top++;

            for (int i = top; i <= bottom && count < elements; i++) {
                result[index++] = matrix[i][right];
                count++;
            }
            right--;

            for (int i = right; i >= left && count < elements; i--) {
                if (top <= bottom) {
                    result[index++] = matrix[bottom][i];
                    count++;
                }
            }
            bottom--;

            for (int i = bottom; i >= top && count < elements; i--) {
                if (left <= right) {
                    result[index++] = matrix[i][left];
                    count++;
                }
            }
            left++;
        }

        return result;
    }
}