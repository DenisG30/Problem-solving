public class Level1 {
    public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2){
        
        if(H1 < H2 || W1 < W2) {
            return false;
        }

        char[][] map1 = new char[H1][W1];
        char[][] map2 = new char[H2][W2];


        for (int i = 0; i < H1; i++) {
            map1[i] = S1.split(" ")[i].toCharArray();
        }

        for (int i = 0; i < H2; i++) {
            map2[i] = S2.split(" ")[i].toCharArray();
        }

        for (int i = 0; i <= H1 - H2; i++) {
            for (int j = 0; j <= W1 - W2; j++) {
                
                boolean res = true; 

                for (int n = 0; n < H2; n++) {
                    for (int m = 0; m < W2; m++) {
                        if (map1[i + n][j + m] != map2[n][m]) {
                            res = false; 
                            break; 
                        }
                    }
                    if (!res) {
                        break; 
                    }
                }    
                if (res) {
                    return true; 
                }
            }
        }
        return false;        
    }
}
