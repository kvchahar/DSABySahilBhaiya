package dynamicprogramming;

import java.util.Arrays;

public class MinimumFallingPathSum2 {
    public int minFallingPathSum(int[][] matrix) {
        int ansMin = Integer.MAX_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, 100);
        }
        for (int c = 0; c < matrix[0].length; c++) {
            int ans = sol(matrix, 0, c, dp);
            ansMin = Math.min(ansMin, ans);
        }

        return ansMin;
    }

    private int sol(int[][] cost, int cr, int cc, int[][] dp) {
        // TODO Auto-generated method stub

        if (cr == cost.length - 1) {
            return cost[cr][cc];
        }

        if (dp[cr][cc] != 100) {
            return dp[cr][cc];
        }

        int ans = Integer.MAX_VALUE;
        for (int c = 0; c < cost.length; c++) {
            if (cc != c) {
                ans = Math.min(ans, sol(cost, cr + 1, c, dp));
            }
        }

        int res = ans + cost[cr][cc];
        dp[cr][cc] = res;

        return res;
    }
}
