package hashmaps;

import java.util.HashMap;

public class FourSumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        HashMap<Integer, Integer> memo = new HashMap<>();

        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                if (memo.containsKey(sum)) {
                    memo.put(sum, memo.get(sum) + 1);
                } else {
                    memo.put(sum, 1);
                }
            }
        }

        int count = 0;
        int target = 0;

        for (int a : nums3) {
            for (int b : nums4) {
                if (memo.containsKey(target - (a + b))) {
                    count += memo.get(target - (a + b));
                }
            }
        }
        return count;
    }
}
