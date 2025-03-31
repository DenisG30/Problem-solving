public class Level1 {
    public static String TheRabbitsFoot(String s, boolean encode) {
        
        String res = "";

        if(encode) {
            String[] strArr = s.split("\s+");

            String newStr = "";

            for (String strArr1 : strArr) {
                newStr += strArr1;
            }

            int N = newStr.length();
        
            double matrix = Math.sqrt(N);
            int rows = (int) Math.floor(matrix);
            int cols = (int) Math.ceil(matrix);

            while (rows * cols < N) {
                rows++;
            }

            char[][] matrixArr = new char[rows][cols];
       
            int i = 0;
            for(int j = 0; j < rows; j++){
                for(int k = 0; k < cols; k++){               
                    if(i < N) { 
                        matrixArr[j][k] = newStr.charAt(i);
                        i ++;
                    }
                } 
            }
        
            int charN = N + (cols - 1);
            char[] arrChar = new char[charN];
        
            int count = 0;
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    if(matrixArr[k][j] != '\u0000') {
                        arrChar[count] = matrixArr[k][j];
                        count++;
                    } 
                }
                if(count < charN) {
                    arrChar[count] = ' ';
                    count++;
                }
            }
            res = new String(arrChar);

        } else {
            
            String[] strArr = s.split("\s+");
            int cols = strArr.length;

            int rows = 0;
            for(int i = 0; i < cols; i++) {
                int countRows = 0;
                for(int j = 0; j < strArr[i].length(); j++) {
                    countRows++;
                }
                if(rows <= countRows) {
                    rows = countRows;
                }
            }

            char[][] matrixArr = new char[rows][cols];
            int N = 0;

            for (int k = 0; k < cols; k++) {
                for (int j = 0; j < strArr[k].length(); j++) {
                    matrixArr[j][k] = strArr[k].charAt(j);
                    N++;
                }
            }

            char[] arrChar = new char[N];

            int letterIndex = 0;
            for(int j = 0; j < rows; j++) {
                for(int k = 0; k < cols; k++){
                    if(matrixArr[j][k] != '\u0000') {
                        arrChar[letterIndex] = matrixArr[j][k];
                        letterIndex++;
                    }
                }
            }

             res = new String(arrChar);
        }

        return res;
    }
}
