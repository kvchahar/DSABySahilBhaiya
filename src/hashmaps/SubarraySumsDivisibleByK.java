package hashmaps;

import java.util.HashMap;

public class SubarraySumsDivisibleByK {
    public static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int answer = 0;
        int prefixRem = 0;

        map.put(prefixRem,1);

        for(int i = 0; i<nums.length; i++){

            prefixRem += nums[i];

            prefixRem = ((prefixRem % k) + k) % k;

            if(map.containsKey(prefixRem)){
                answer += map.get(prefixRem);
                map.put(prefixRem,map.get(prefixRem) + 1);
            }else{
                map.put(prefixRem,1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        System.out.println(subarraysDivByK(nums,k)); // 7
    }
}
