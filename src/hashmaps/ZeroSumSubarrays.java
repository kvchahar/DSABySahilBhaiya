package hashmaps;

import java.util.HashMap;

public class ZeroSumSubarrays {
    public static long findSubarray(long[] arr ,int n)
    {
        HashMap<Integer,Integer> memo = new HashMap<>();

        int prefixSum = 0;
        int ans = 0;
        memo.put(prefixSum,1);
        for(int i = 0; i<n; i++){
            long currentValue = arr[i];

            prefixSum += currentValue;
            if(memo.containsKey(prefixSum)){
                int value = memo.get(prefixSum);
                ans += value;
                memo.put(prefixSum,value+1);
            }else{
                memo.put(prefixSum , 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        long[] arr = {6,-1,-3,4,-2,2,4,6,-12,-7};
        System.out.println(findSubarray(arr,arr.length)); // 4
    }
}
