package dynamicprogramming.tabulation;

import java.util.HashMap;

public class HouseRobberII {
    // Space Optimization

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] temp1 = new int[n - 1];
        int[] temp2 = new int[n - 1];

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                temp1[i - 1] = nums[i];
            }

            if (i != n - 1) {
                temp2[i] = nums[i];
            }
        }

        int first = maxMoney(temp1, 0, new HashMap<>());
        int second = maxMoney(temp2, 0, new HashMap<>());

        return Math.max(first, second);
    }

    public int maxMoney(int[] nums, int currentHouse, HashMap<Integer, Integer> memo) {

        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int take = nums[i];
            if (i > 1) {
                take += prev2;
            }

            int notTake = 0 + prev;

            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

}
