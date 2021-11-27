package dynamicprogramming;

import java.util.HashMap;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        return isPossible(nums,0, new HashMap<>());
    }

    public static boolean isPossible(int[] nums, int currentIndex, HashMap<Integer,Boolean> memo){


        if(currentIndex>=nums.length-1){
            return true;
        }

        int currentKey = currentIndex;

        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }


        int currentValue = nums[currentIndex];
        boolean ans = false;

        for(int i=1; i<=currentValue; i++){

            boolean temp = isPossible(nums, currentIndex + i, memo);
            ans = ans || temp;
            memo.put(currentKey,ans);

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4}; // true
        System.out.println(canJump(nums));
    }
}