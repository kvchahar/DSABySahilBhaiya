package hashmaps;

import java.util.HashMap;

public class LargestSubarrayWithZeroSum {
    static int maxLen(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int answer = 0;

        map.put(prefixSum, -1);

        for (int i = 0; i < n; i++) {
            int currentValue = arr[i];
            prefixSum += currentValue;

            if (map.containsKey(prefixSum)) {
                int temp = i - map.get(prefixSum);
                answer = Math.max(answer, temp);
            } else {
                map.put(prefixSum, i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {15,-2,2,-8,1,7,10,23};
        int n = 8;
        System.out.println(maxLen(arr,n)); // 5
    }
}
