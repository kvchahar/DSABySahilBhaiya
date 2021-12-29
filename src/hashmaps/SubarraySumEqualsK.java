package hashmaps;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int ans = 0;
        int prefixSum = 0;
        HashMap<Integer,Integer> memo = new HashMap<>();

        memo.put(prefixSum,1);

        for(int i = 0; i<nums.length; i++){
            prefixSum += nums[i];

            int sum = prefixSum - k;

            if(memo.containsKey(sum)){
                int value = memo.get(sum);
                ans += value;

            }
            if(memo.containsKey(prefixSum)){
                int value = memo.get(prefixSum);
                memo.put(prefixSum,value+1);
            }

            else{
                memo.put(prefixSum,1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,1};
        int[] arr2 = {1,2,3};
        System.out.println(subarraySum(arr1,2)); // 2
        System.out.println(subarraySum(arr2,3)); // 2
    }
}
