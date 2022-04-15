package dynamicprogramming;

import java.util.Arrays;

public class CherryPickupII {
    public int cherryPickup(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;

        int dp[][][] = new int[n][m][m];

        for (int row1[][] : dp) {
            for (int row2[] : row1) {
                Arrays.fill(row2, -1);
            }
        }


        int ans = maxCherry(grid, 0, 0, m - 1, dp);

        return ans;
    }

    private int maxCherry(int[][] grid, int i, int j1, int j2, int[][][] dp) {


        if (j1 >= grid[0].length || j2 >= grid[0].length || j1 < 0 || j2 < 0) {
            return 0;
        }

        if (i == grid.length - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }


        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        int max = Integer.MIN_VALUE;
        for (int robot1 = -1; robot1 <= 1; robot1++) {
            for (int robot2 = -1; robot2 <= 1; robot2++) {
                int cherries = 0;
                if (j1 == j2) {
                    cherries = grid[i][j1] + maxCherry(grid, i + 1, j1 + robot1, j2 + robot2, dp);
                } else {
                    cherries = grid[i][j2] + grid[i][j1] + maxCherry(grid, i + 1, j1 + robot1, j2 + robot2, dp);
                }
                max = Math.max(max, cherries);
                dp[i][j1][j2] = max;
            }
        }
        return max;
    }
}
