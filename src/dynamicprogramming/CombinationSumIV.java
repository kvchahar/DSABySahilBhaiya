package dynamicprogramming;

import java.util.HashMap;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        return totalCombinations(0,nums,target, new HashMap<>());
    }

    public int totalCombinations(int currentIndex , int[] nums, int target,HashMap<String,Integer> memo){

        if(currentIndex>=nums.length && target!=0){
            return 0;
        }

        if(target==0){
            return 1;
        }

        String currentKey = Integer.toString(currentIndex) + "_" + Integer.toString(target);

        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }

        int consider = 0;

        if(target>=nums[currentIndex]){
            consider = totalCombinations(0, nums, target - nums[currentIndex],memo);
        }

        int notConsider = totalCombinations(currentIndex+1, nums, target,memo);

        int total = consider + notConsider;

        memo.put(currentKey,total);

        return total;
    }
}