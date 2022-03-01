package dynamicprogramming;

import java.util.HashMap;

public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1){
            return nums[0];
        }

        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];

        for(int i = 0; i<n; i++){
            if(i!=0){
                temp1[i-1] = nums[i];
            }

            if(i!=n-1){
                temp2[i] = nums[i];
            }
        }

        int first =  maxMoney(temp1,0, new HashMap<>());
        int second =  maxMoney(temp2,0, new HashMap<>());

        return Math.max(first,second);
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
}