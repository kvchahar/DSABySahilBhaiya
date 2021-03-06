package dynamicprogramming;

import java.util.HashMap;

class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {

        int total = 0;

        for(int num : nums){
            total = total + num;
        }

        int targetSum = total / 2;
        if(total%2==0){
            return isPossible(nums, 0, targetSum, new HashMap<>());
        }
        return false;
    }

    public boolean isPossible(int[] nums, int currentIndex, int targetSum, HashMap<String,Boolean> memo){

        if(targetSum==0){
            return true;
        }

        if(currentIndex>=nums.length){
            return false;
        }

        String currentKey = Integer.toString(currentIndex) + "_" + Integer.toString(targetSum);

        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }

        boolean consider = false;
        if(nums[currentIndex]<=targetSum){
            consider = isPossible(nums, currentIndex + 1, targetSum - nums[currentIndex], memo);
        }

        if(consider){
            memo.put(currentKey, true);
            return true;
        }

        boolean notConsider = isPossible(nums, currentIndex + 1, targetSum, memo);
        memo.put(currentKey, consider || notConsider);

        return memo.get(currentKey);

    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        int[] nums = {1,5,11,5};
        System.out.println(p.canPartition(nums));
    }
}

//        Time Complexity: O(N*K) + O(N)
//        Reason: There are N*K states therefore at max âN*Kâ new problems will be solved and we are running a for loop for âNâ times to calculate the total sum

//        Space Complexity: O(N*K) + O(N)
//        Reason: We are using a recursion stack space(O(N)) and a 2D array ( O(N*K)).