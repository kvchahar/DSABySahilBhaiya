package dynamicprogramming;

import java.util.HashMap;

public class NumberOfDiceRollsWithTargetSum {
    private static final int MOD = 1000000007;

    public static int numRollsToTarget(int d, int f, int target) {
        return totalWays(d, f, target, new HashMap<>());
    }

    public static int totalWays(int dice, int faces, int target, HashMap<String, Integer> memo) {

        if (dice == 0 && target != 0) {
            return 0;
        }

        if (dice == 0 && target == 0) {
            return 1;
        }

        String currentKey = Integer.toString(dice) + "_" + Integer.toString(target);
        if (memo.containsKey(currentKey)) {
            return memo.get(currentKey);
        }

        int ans = 0;
        for (int face = 1; face <= faces; face++) {
            int tempAns = totalWays(dice - 1, faces, target - face, memo);
            ans = (ans + tempAns) % MOD;
        }
        memo.put(currentKey, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(1,6,3)); // 1
    }
}
