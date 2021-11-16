package dynamicprogramming;

import java.util.HashMap;

class HouseRobber {
    public int rob(int[] nums) {
        return maxMoney(nums,0, new HashMap<>());
    }

    public int maxMoney(int[] nums, int currentHouse, HashMap<Integer,Integer> memo){

        if(currentHouse >= nums.length){
            return 0;
        }

        int currentKey = currentHouse;
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }


        int robbedMoney = nums[currentHouse] + maxMoney(nums, currentHouse + 2,memo);
        int notRobbedMoney = maxMoney(nums, currentHouse + 1, memo);

        memo.put(currentKey, Math.max(robbedMoney, notRobbedMoney));
        return Math.max(robbedMoney, notRobbedMoney);
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int[] nums1 = {1,2,3,1}; // 4
        int[] nums2 = {2,7,9,3,1}; // 12
        System.out.println(houseRobber.rob(nums1));
        System.out.println(houseRobber.rob(nums2));
    }
}