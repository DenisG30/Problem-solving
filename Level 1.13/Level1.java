public class Level1 {
    private static int fromHexadecimal(int numArr){ 
        int len = String.valueOf(numArr).length();
        int sum = 0;
        for(int i = 0; i < len; i++) {
            int num = 0;
            if(i != len - 1) {
                num = (int) (numArr / Math.pow(10, len - (i + 1)));
                numArr = (int) (numArr % Math.pow(10, len - (i + 1)));
            } else {
                num = numArr % 10;
            }
           sum += num * Math.pow(16, len - (i + 1));
        }
        return sum;   
    }

    private static int fromOctal(int numArr){
        int len = String.valueOf(numArr).length();
        int sum = 0;
        for(int i = 0; i < len; i++) {
            int num = 0;
            if(i != len - 1) {
                num = (int) (numArr / Math.pow(10, len - (i + 1)));
                numArr = (int) (numArr % Math.pow(10, len - (i + 1)));
            } else {
                num = numArr % 10;
            }
           sum += num * Math.pow(8, len - (i + 1));
        }
        return sum;
    }

    public static int[] UFO(int N, int[] data, boolean octal) {
        int[] dataDecimal = new int[N];
        for(int i = 0; i < N; i++) {
            if(octal) {
                dataDecimal[i] = fromOctal(data[i]);
            } else {
                dataDecimal[i] = fromHexadecimal(data[i]);
            }
        }
        return dataDecimal;
    } 
}
