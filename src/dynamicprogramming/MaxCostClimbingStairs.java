package dynamicprogramming;

public class MaxCostClimbingStairs {
    public static int maxCostClimbingStair(int[] cost) {
        int a = maxCost(cost, 0);
        int b = maxCost(cost, 1);
        return Math.max(a, b);
    }

    public static int maxCost(int[] cost, int currentIndex) {
        if (currentIndex == cost.length) {
            return 0;
        }

        if (currentIndex > cost.length) {
            return -1000;
        }

        int oneJump = cost[currentIndex] + maxCost(cost, currentIndex + 1);
        int twoJumps = cost[currentIndex] + maxCost(cost, currentIndex + 2);

        return Math.max(oneJump, twoJumps);
    }

    public static void main(String[] args) {
        int[] cost = {4,75,11};
        System.out.println(maxCostClimbingStair(cost));
    }
}
