public class Level1 {
    public static int squirrel(int N) {
        int factorial = 1;
        if(N != 0){
            for (int i = 1; i <= N; i++) {
                factorial = factorial * i;
            }
            return Character.getNumericValue(Integer.toString(factorial).charAt(0));
        } else{
            return 1;
        }
    }
}
