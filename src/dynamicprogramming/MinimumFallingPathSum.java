package dynamicprogramming;

import java.util.HashMap;

public class MinimumFallingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = 10000;
        HashMap<String, Integer> memo = new HashMap<>();
        for (int col = 0; col < n; col++) {
            int tempAns = minCost(matrix, 0, col, n, memo);
            ans = (int) (Math.min(ans, tempAns));
        }
        return ans;
    }

    public static int minCost(int[][] matrix, int currentRow, int currentColumn, int N, HashMap<String, Integer> memo) {


        if (currentRow >= N || currentColumn >= N || currentRow < 0 || currentColumn < 0) {
            return 10000;
        }

        if (currentRow == N - 1) {
            return matrix[currentRow][currentColumn];
        }

        String currentKey = Integer.toString(currentRow) + "_" + Integer.toString(currentColumn);
        if (memo.containsKey(currentKey)) {
            return memo.get(currentKey);
        }

        int down = matrix[currentRow][currentColumn] + minCost(matrix, currentRow + 1, currentColumn, N, memo);
        int diagonalLeft = matrix[currentRow][currentColumn] + minCost(matrix, currentRow + 1, currentColumn - 1, N, memo);
        int diagonalRight = matrix[currentRow][currentColumn] + minCost(matrix, currentRow + 1, currentColumn + 1, N, memo);

        int max = (int) (Math.min(down, (int) (Math.min(diagonalLeft, diagonalRight))));
        memo.put(currentKey, max);

        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(minFallingPathSum(matrix)); // 13
    }
}