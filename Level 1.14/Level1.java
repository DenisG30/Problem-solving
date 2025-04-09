public class Level1 {
    public static int Unmanned(int L, int N, int[][] track) {
        int timesUp = 0 ;
        int locationCar = 0; 

        for (int i = 0; i < N; i++) {
            locationCar = track[i][0];
            if(i != 0) {
                timesUp += locationCar - track[i - 1][0]; 
            } else {
                timesUp += locationCar;
            }
            int red = track[i][1]; 
            int green = track[i][2]; 
            int cycleRedGreen = red + green; 

            int restTime = timesUp % cycleRedGreen;
            int numCycle = timesUp / cycleRedGreen;
            int colorLights = timesUp - cycleRedGreen * numCycle;

            if (colorLights < red) {
                timesUp += (red - restTime);
            }
        }
        timesUp = timesUp + (L - locationCar);
        return timesUp;
    }
}
