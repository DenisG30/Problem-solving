public class Level1{
    public static int odometer(int [] oksana) {
        int sumDist = 0;
        int lastIndex = 0;

        for(int i = 0; i < oksana.length; i += 2){
            if(i + 1 >= oksana.length) {
                break;
            }

            if (i == 0) {
                int dist = oksana[i] * oksana[i + 1];
                sumDist = sumDist + dist;
            } else {
                int dist = (oksana[i + 1] - oksana[lastIndex + 1]) * oksana[i];
                lastIndex = i;
                sumDist = sumDist + dist;
            }
            
        }
        return sumDist;
    }
}

