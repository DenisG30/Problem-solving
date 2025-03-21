public class Level1 {
    public static int [] SynchronizingTables(int N, int [] ids, int [] salary) {
        int[][] keyValue = new int [N][2];
        int[] temp = new int[N];

        for(int i = 0; i < N; i++) {
            temp[i] = ids[i];
        }
        
        boolean changeSalary = true;
        boolean changeTemp = true;
        
        while(changeSalary || changeTemp) {
            changeSalary = false;
            changeTemp = false;
            int x;
            for(int i = 0; i < N - 1; i++) {
                if(salary[i] > salary[i + 1]) {
                    x = salary[i];
                    salary[i] = salary[i + 1];
                    salary[i + 1] = x;
                    changeSalary = true;
                }
                if(temp[i] > temp[i + 1]) {
                    x = temp[i];
                    temp[i] = temp[i + 1];
                    temp[i + 1] = x;
                    changeTemp = true;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            keyValue[i][0] = temp[i];
            keyValue[i][1] = salary[i];
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(ids[i] == keyValue[j][0]) {
                    salary[i] = keyValue[j][1];
                    break;  
                }
            }  
        }
        return salary;
    }
}
