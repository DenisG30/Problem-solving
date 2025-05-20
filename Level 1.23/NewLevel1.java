public class Level1 {
    public static String[] TreeOfLife(int H, int W, int N, String[] tree) {
        char[][] grid = new char[H][W]; 
        int[][] gridInt = new int[H][W]; 
        
        for (int i = 0; i < H; i++) {
            grid[i] = tree[i].toCharArray();
        }
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(grid[i][j] == '.') {
                    gridInt[i][j] = 0;
                }

                if(grid[i][j] == '+') {
                    gridInt[i][j] = 1;
                }
            }
        }    

        for (int year = 1; year <= N; year++) {
            gridInt = age(gridInt); 
            if(year % 2 == 0) {
                gridInt = delete(gridInt);
            } else {
                gridInt = fillCells(gridInt);
            }
        }
        
        grid = toChar(gridInt);

        String[] result = new String[H];
        for (int i = 0; i < H; i++) {
            result[i] = new String(grid[i]);
        }
        return result;
    }

    private static int[][] age(int[][] grid) {
        int[][] newGrid = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                newGrid[i][j] = grid[i][j] + 1;
            }
        }
        return newGrid;
    }
    
    private static int[][] fillCells(int[][] grid) {
        int[][] newGrid = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    newGrid[i][j] = 1; 
                } else {
                    newGrid[i][j] = grid[i][j]; 
                }
            }
        }
        return newGrid;
    }
    
    private static int[][] delete(int[][] grid) {
        boolean[][] toDelete = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] >= 3) { 
                    toDelete[i][j] = true;
                    toDelete = markToDelete(toDelete, grid, i, j);
                }
            }
        }

        int[][] newGrid = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (toDelete[i][j]) {
                    newGrid[i][j] = 0;
                } else {
                    newGrid[i][j] = grid[i][j]; 
                }
            }
        }
        return newGrid;
    }

    private static boolean[][] markToDelete(boolean[][] toDelete, int[][] grid, int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];     
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                toDelete[nx][ny] = true; 
            }
        }
        return toDelete;
    }

    private static char[][] toChar(int[][] grid) {
        char[][] newGrid = new char[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    newGrid[i][j] = '.';
                } else {
                    newGrid[i][j] = '+';
                }
            }
        }
        return newGrid;
    }    
}
