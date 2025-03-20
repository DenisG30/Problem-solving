public class Level1 {
        public static int [] MadMax (int N, int [] Tele) {
            boolean change = true;
            int x = 0;
    
            while(change) {
                change = false;
                for(int i = 0; i < N - 1; i++) {
                    if(Tele[i] > Tele[i + 1]) {
                        x = Tele[i];
                        Tele[i] = Tele[i + 1];
                        Tele[i + 1] = x;
                        change = true;
                    }
                }
            }
            
            x = Tele[N - 1];
            Tele[N - 1] = Tele[N / 2];
            Tele[N / 2] = x;
    
            change = true;
            while(change) {
                change = false;
                for(int i = N / 2; i < N - 1; i++) {
                    if(Tele[i] < Tele[i + 1]) {
                        x = Tele[i];
                        Tele[i] = Tele[i + 1];
                        Tele[i + 1] = x;
                        change = true;
                    }
                }
            }
            return Tele;
        }
}
