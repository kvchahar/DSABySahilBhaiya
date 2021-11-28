package dynamicprogramming;

import java.util.*;

public class MaximumPathSumInMatrix {
    static int maximumPath(int N, int Matrix[][]) {
        int ans = 0;
        HashMap<String, Integer> memo = new HashMap<>();
        for (int col = 0; col < N; col++) {

            int temp = maxCost(Matrix, 0, col, N, memo);
            ans = (int) (Math.max(ans, temp));
        }
        return ans;
    }

    static int maxCost(int Matrix[][], int cr, int cc, int n, HashMap<String, Integer> memo) {
        if (cr >= n || cc >= n || cc < 0 || cr < 0) {
            return 0;
        }
        if (cr == n - 1) {
            return Matrix[cr][cc];
        }
        String currentKey = Integer.toString(cr) + "_" + Integer.toString(cc);
        if (memo.containsKey(currentKey)) {
            return memo.get(currentKey);
        }
        int down = Matrix[cr][cc] + maxCost(Matrix, cr + 1, cc, n, memo);
        int diagonalLeft = Matrix[cr][cc] + maxCost(Matrix, cr + 1, cc - 1, n, memo);
        int diagonalRight = Matrix[cr][cc] + maxCost(Matrix, cr + 1, cc + 1, n, memo);

        int max = (int) (Math.max(down, (int) (Math.max(diagonalLeft, diagonalRight))));

        memo.put(currentKey, max);
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {{348, 391},
                {618, 193}};
        System.out.println(maximumPath(matrix.length, matrix)); // 1009
    }
}