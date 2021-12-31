package hashmaps;

import java.util.HashMap;

public class SubarraysWithEqualOnesAndZeros {
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        HashMap<Integer,Integer> memo = new HashMap<>();

        int prefixSum = 0;
        int ans = 0;
        memo.put(prefixSum,1);
        for(int i = 0; i<n; i++){
            long currentValue = arr[i];

            if(currentValue==0){
                prefixSum += -1;
            }else{
                prefixSum += 1;
            }

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
        int[] arr = {1,0,0,1,0,1,1};
        System.out.println(countSubarrWithEqualZeroAndOne(arr,arr.length));
    }
}
