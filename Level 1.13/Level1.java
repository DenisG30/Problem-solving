public class Level1 {
    private static int decision(int numArr, boolean octal){
        int decimal;
        if(octal) {
            decimal = 8;
        } else {
            decimal = 16;
        }
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
           sum += num * Math.pow(decimal, len - (i + 1));
        }
        return sum;
    }

    public static int[] UFO(int N, int[] data, boolean octal) {
        int[] dataDecimal = new int[N];
        for(int i = 0; i < N; i++) {
                dataDecimal[i] = decision(data[i], octal);
            }
        }
        return dataDecimal;
    } 
}
