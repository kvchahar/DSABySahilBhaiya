package dynamicprogramming;

import java.util.HashMap;

public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        HashMap<String, Integer> memo = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int side = maxSquare(i, j, m, n, matrix, memo);
                    ans = (int) (Math.max(ans, side * side));
                }
            }
        }
        return ans;

    }

    public static int maxSquare(int currentRow, int currentColumn, int m, int n, char[][] matrix, HashMap<String, Integer> memo) {

        if (currentRow >= m || currentColumn >= n || currentColumn < 0 || matrix[currentRow][currentColumn] == '0') {
            return 0;
        }

        String currentKey = Integer.toString(currentRow) + "_" + Integer.toString(currentColumn);

        if (memo.containsKey(currentKey)) {
            return memo.get(currentKey);
        }

        int right = 1 + maxSquare(currentRow, currentColumn + 1, m, n, matrix, memo);
        int down = 1 + maxSquare(currentRow + 1, currentColumn, m, n, matrix, memo);
        int diagonal = 1 + maxSquare(currentRow + 1, currentColumn + 1, m, n, matrix, memo);


        int ans = (int) (Math.min(right, (int) (Math.min(down, diagonal))));
        memo.put(currentKey, ans);

        return ans;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(matrix)); // 4
    }
}