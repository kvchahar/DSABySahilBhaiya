package dynamicprogramming;

import java.util.HashMap;

public class TargetSum {
    public static int targetSum(int[] nums, int target) {
        return totalWays(0, nums, target, new HashMap<>());
    }

    public static int totalWays(int currentIndex, int[] nums, int target, HashMap<String, Integer> memo) {

        if (currentIndex >= nums.length && target == 0) {
            return 1;
        }

        if (currentIndex >= nums.length && target != 0) {
            return 0;
        }

        String currentKey = Integer.toString(currentIndex) + "_" + Integer.toString(target);

        if (memo.containsKey(currentKey)) {
            return memo.get(currentKey);
        }

        int posSign = totalWays(currentIndex + 1, nums, target - nums[currentIndex], memo);
        int negSign = totalWays(currentIndex + 1, nums, target + nums[currentIndex], memo);

        memo.put(currentKey, posSign + negSign);
        return posSign + negSign;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(targetSum(nums, target));
    }
}
