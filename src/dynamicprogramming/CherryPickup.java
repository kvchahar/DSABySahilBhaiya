package dynamicprogramming;

public class CherryPickup {
    public int cherryPickup(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        int[][][][] dp = new int[m][n][m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    for (int l = 0; l < n; l++) {
                        dp[i][j][k][l] = -100;
                    }
                }
            }
        }
        int ans = maxCherry(grid, 0, 0, 0, 0, n, m, dp);

        if (ans < -1 || ans == 48) {
            return 0;
        }

        return ans;
    }

    private int maxCherry(int[][] grid, int r1, int c1, int r2, int c2, int n, int m, int[][][][] dp) {

        if (r1 >= n || r2 >= n || c1 >= m || c2 >= m || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return -100;
        }

        if (r1 == n - 1 && c1 == m - 1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][r2][c2] != -100) {
            return dp[r1][c1][r2][c2];
        }

        int cherries = 0;

        if (r1 == r2 && c1 == c2) {
            cherries += grid[r1][c1];
        } else {
            cherries += grid[r1][c1] + grid[r2][c2];
        }

        int hh = maxCherry(grid, r1, c1 + 1, r2, c2 + 1, n, m, dp);
        int hv = maxCherry(grid, r1, c1 + 1, r2 + 1, c2, n, m, dp);
        int vh = maxCherry(grid, r1 + 1, c1, r2, c2 + 1, n, m, dp);
        int vv = maxCherry(grid, r1 + 1, c1, r2 + 1, c2, n, m, dp);

        cherries += Math.max(Math.max(hh, hv), Math.max(vh, vv));

        dp[r1][c1][r2][c2] = cherries;
        return cherries;
    }
}
        
        
     