public class Level1 {
    public static String PatternUnlock(int N, int [] hits) {
        double endLength = 0.0;

        int[][] arr = 
        {
            {6, 1, 9},                 
            {5, 2, 8}, 
            {4, 3, 7}
        };
        
        int[][] position = new int[arr.length * arr[0].length][3]; 
        
        int indPos = 0;
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                position[indPos][0] = arr[i][j];
                position[indPos][1] = i;
                position[indPos][2] = j;
                indPos ++;
            }
        }
        
        for(int i = 0; i < N - 1; i++) {
            int x1 = 0; 
            int y1 = 0;
            int x2 = 0;
            int y2 = 0;
            
            
            for (int j = 0; j < position.length; j++) {
                if (hits[i] == position[j][0]) {
                    x1 = position[j][1];
                    y1 = position[j][2];
                    break; 
                }
            }

            
            for (int j = 0; j < position.length; j++) {
                if (hits[i + 1] == position[j][0]) {
                    x2 = position[j][1];
                    y2 = position[j][2];
                    break; 
                }
            }
                
                
            if(x1 == x2 || y1 == y2) {
                double coordinatePoint = Math.sqrt(Math.pow((x2 - x1), 2)) + Math.sqrt(Math.pow((y2 - y1), 2));
                endLength += coordinatePoint;
            } else { 
                double coordinatePoint = (((Math.sqrt(Math.pow((x2 - x1), 2))) + (Math.sqrt(Math.pow((y2 - y1), 2)))) / 2) * Math.sqrt(1*1 + 1*1);
                endLength += coordinatePoint;
            }
                
        }

        String strLength = String.format("%.5f", endLength);
        String res = strLength.replace(",", "").replace("0", "");

        return res;  
    }
}
