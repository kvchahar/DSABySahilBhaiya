package graph;

public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        int total = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                    checkDFS(i, j, grid.length, grid[0].length, visited, grid);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    total += 1;
                }
            }
        }
        return total;
    }

    private void checkDFS(int currRow, int currCol, int m, int n, boolean[][] visited, int[][] grid) {
        if (currRow < 0 || currRow >= m || currCol < 0 || currCol >= n || visited[currRow][currCol]) {
            return;
        }

        visited[currRow][currCol] = true;

        if (grid[currRow][currCol] == 1) {
            checkDFS(currRow - 1, currCol, m, n, visited, grid);
            checkDFS(currRow + 1, currCol, m, n, visited, grid);
            checkDFS(currRow, currCol - 1, m, n, visited, grid);
            checkDFS(currRow, currCol + 1, m, n, visited, grid);
            grid[currRow][currCol] = 0;
        }
    }
}
