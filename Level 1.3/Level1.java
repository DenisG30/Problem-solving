public class Level1 {
    public static int ConquestCampaign(int N, int M, int L, int [] battalion) {
        
        int[][] poligon = new int[N][M];
        int[][] temp = new int[N][M];
        int control = 0;
        int days = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                poligon[i][j] = 0;
                temp[i][j] = 0;
                for (int p = 0; p < L * 2; p += 2) {
                    if (i == battalion[p] - 1 && j == battalion[p + 1] - 1) {
                        poligon[i][j] = 1;
                        temp[i][j] = 1;
                        control += 1;
                        break;
                    }
                }
            }
        }
        
        while (control < (N * M)) {
            days += 1; 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(poligon[i][j] == 1) {
                        if(i != 0) {
                            temp[i - 1][j] = 1;
                        }
                        if(i != N - 1)  {
                            temp[i + 1][j] = 1;
                        }
                        if(j != 0) {
                            temp[i][j - 1] = 1;
                        }
                        if(j != M - 1) {
                            temp[i][j + 1] = 1;
                        }
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (temp[i][j] == 1) {
                        if (poligon[i][j] == 0) {
                            poligon[i][j] = 1;
                            control += 1;
                        }
                    }    
                }
            }
        }
        return days;    
    }
}
