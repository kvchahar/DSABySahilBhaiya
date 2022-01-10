package graph;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    totalIslands(grid, i, j, m, n);
                    total += 1;
                }
            }
        }

        return total;
    }

    public static void totalIslands(char[][] grid, int currRow, int currCol, int m, int n) {

        if (currRow < 0 || currCol < 0 || currRow >= m || currCol >= n || grid[currRow][currCol] != '1') {
            return;
        }

        grid[currRow][currCol] = '2';

        totalIslands(grid, currRow + 1, currCol, m, n);
        totalIslands(grid, currRow, currCol + 1, m, n);
        totalIslands(grid, currRow - 1, currCol, m, n);
        totalIslands(grid, currRow, currCol - 1, m, n);
        return;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        System.out.println(numIslands(grid));
    }
}
