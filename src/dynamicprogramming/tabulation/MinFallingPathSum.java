package dynamicprogramming.tabulation;

public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = m;

        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int down = matrix[i][j] + dp[i - 1][j];
                int leftDiagonal = 1000;
                int rightDiagonal = 1000;
                if (j - 1 >= 0)
                    leftDiagonal = matrix[i][j] + dp[i - 1][j - 1];
                else
                    leftDiagonal = Integer.MAX_VALUE;
                if (j + 1 < n)
                    rightDiagonal = matrix[i][j] + dp[i - 1][j + 1];
                else
                    rightDiagonal = Integer.MAX_VALUE;

                dp[i][j] = Math.min(down, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        int minimum = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            minimum = Math.min(minimum, dp[m - 1][j]);
        }

        return minimum;
    }
}
