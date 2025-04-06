public class Level1 {
    public static String MassVote(int N, int [] votes) {
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += votes[i];
        }
        double vinnerOne = 0;
        boolean vinOne = false;
        boolean vinTwo = false;
        int k = 0;

        for(int i = 0; i < N; i++) {
            double value = votes[i];
            if(value > vinnerOne) {
                vinnerOne = value;
                k = i + 1;
                vinOne = true;
                vinTwo = false;
            } else if (value == vinnerOne) {
                vinTwo = true;   
            }
        }

        if(!vinTwo && vinnerOne > sum / 2) {
            return "majority winner " + k ;
        } else if(!vinTwo && vinnerOne <= sum / 2) {
            return "minority winner " + k;
        } else if(vinOne && vinTwo) {
            return "no winner";
        }
        return null;
    }
}
