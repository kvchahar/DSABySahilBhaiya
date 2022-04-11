package dynamicprogramming;

import java.util.HashMap;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        return pathSum(0, 0, triangle, triangle.size(), new HashMap<>());
    }

    private int pathSum(int row, int col, List<List<Integer>> triangle, int size, HashMap<String, Integer> memo) {

        if (row == size - 1) {
            return triangle.get(size - 1).get(col);
        }

        String currentKey = Integer.toString(row) + "_" + Integer.toString(col);

        if (memo.containsKey(currentKey)) {
            return memo.get(currentKey);
        }

        int down = triangle.get(row).get(col) + pathSum(row + 1, col, triangle, size, memo);
        int diagonal = triangle.get(row).get(col) + pathSum(row + 1, col + 1, triangle, size, memo);

        int ans = Math.min(down, diagonal);

        memo.put(currentKey, ans);

        return ans;
    }
}
