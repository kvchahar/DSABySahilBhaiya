package hashmaps;

import java.util.HashMap;

public class LongestSubarrayWithSumDivisibleByK {
     static int longSubarrWthSumDivByK(int nums[], int n, int k)
    {
        // Complete the function
        HashMap<Integer,Integer> map = new HashMap<>();

        int answer = 0;
        int prefixRem = 0;

        map.put(prefixRem,-1);

        for(int i = 0; i<nums.length; i++){

            prefixRem += nums[i];

            prefixRem = ((prefixRem % k) + k) % k;

            if(map.containsKey(prefixRem)){
                int prevIndex = map.get(prefixRem);
                answer = Math.max(answer, i - prevIndex);
            }else{
                map.put(prefixRem,i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(longSubarrWthSumDivByK(new int[]{2,7,6,1,4,5},6,3));
    }
}
