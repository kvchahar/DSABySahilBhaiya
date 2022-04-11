package dynamicprogramming.tabulation;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {

        // Tabulation

        int size = triangle.size();
        int[] dp = new int[size];
        int[] current = new int[size];

        for (int j = 0; j < size; j++) {
            dp[j] = triangle.get(size - 1).get(j);
        }


        for (int i = size - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + dp[j];
                int diagonal = triangle.get(i).get(j) + dp[j + 1];
                current[j] = Math.min(down, diagonal);
            }
            for (int k = 0; k < size; k++) {
                dp[k] = current[k];
            }
        }

        return dp[0];
    }
}