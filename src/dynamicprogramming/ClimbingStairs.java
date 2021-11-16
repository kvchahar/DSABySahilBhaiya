package dynamicprogramming;

import java.util.HashMap;

public class ClimbingStairs {

    public static int climbingStairs(int n) {
        return totalWays(0, n, new HashMap<Integer, Integer>());
    }

    public static int totalWays(int currentStair, int targetStair, HashMap<Integer, Integer> memo) {
        if (currentStair == targetStair) {
            return 1;
        }

        if (currentStair > targetStair) {
            return 0;
        }

        int currentKey = currentStair;

        if (memo.containsKey(currentKey)) {
            return memo.get(currentKey);
        }

        int oneStep = totalWays(currentStair + 1, targetStair, memo);
        int twoSteps = totalWays(currentStair + 2, targetStair, memo);

        memo.put(currentStair, oneStep + twoSteps);
        return oneStep + twoSteps;
    }

    public static void main(String[] args) {
        System.out.println(climbingStairs(4));
    }
}
