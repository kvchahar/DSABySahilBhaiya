package dynamicprogramming;

import java.util.HashMap;

public class JumpGameII {
    public static int jump(int[] nums) {
        return isPossible(nums,0, new HashMap<>());
    }

    public static int isPossible(int[] nums, int currentIndex, HashMap<Integer,Integer> memo){


        if(currentIndex>=nums.length-1){
            return 0;
        }

        int currentKey = currentIndex;

        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }


        int currentValue = nums[currentIndex];
        int ans = 10001;

        for(int i=1; i<=currentValue; i++){

            int temp = 1 + isPossible(nums, currentIndex + i, memo);
            ans = Math.min(ans,temp);
            memo.put(currentKey,ans);

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums =  {2,3,1,1,4};
        System.out.println(jump(nums)); // 2
    }
}

// time complexity O(n * max(nums))
// space complexity O(n)