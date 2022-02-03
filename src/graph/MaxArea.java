package graph;

public class MaxArea {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;

        int n = grid[0].length;


        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int temp = totalIslands(grid, i, j, m, n);
                    total = Math.max(total, temp);
                }
            }
        }

        return total;
    }

    public int totalIslands(int[][] grid, int currRow, int currCol, int m, int n) {

        if (currRow < 0 || currCol < 0 || currRow >= m || currCol >= n || grid[currRow][currCol] != 1) {
            return 0;
        }

        grid[currRow][currCol] = '2';

        int a = totalIslands(grid, currRow + 1, currCol, m, n);
        int b = totalIslands(grid, currRow, currCol + 1, m, n);
        int c = totalIslands(grid, currRow - 1, currCol, m, n);
        int d = totalIslands(grid, currRow, currCol - 1, m, n);
        // grid[currRow][currCol] = '0';
        return 1 + a + b + c + d;
    }
}
