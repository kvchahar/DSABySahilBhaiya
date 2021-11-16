package dynamicprogramming;

import java.util.HashMap;

public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        int a = minCost(cost, 0, new HashMap<>());
        int b = minCost(cost, 1,new HashMap<>());
        return Math.min(a, b);
    }
    public static int minCost(int[] cost, int currentIndex, HashMap<Integer,Integer> memo) {
        if (currentIndex == cost.length) {
            return 0;
        }
        if (currentIndex > cost.length) {
            return 1000;
        }

        int currentKey = currentIndex;
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
//
        int oneJump = cost[currentIndex] + minCost(cost, currentIndex + 1,memo);
        int twoJumps = cost[currentIndex] + minCost(cost, currentIndex + 2,memo);

        memo.put(currentIndex,Math.min(oneJump,twoJumps));
        return Math.min(oneJump, twoJumps);
    }
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
    }
}
