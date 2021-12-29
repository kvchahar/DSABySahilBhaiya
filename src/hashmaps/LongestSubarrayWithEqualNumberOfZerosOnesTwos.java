package hashmaps;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubarrayWithEqualNumberOfZerosOnesTwos {

    public static int solution(int[] arr) {

        int zerosCount = 0;
        int onesCount = 0;
        int twosCount = 0;

        int ans = 0;

        HashMap<String, Integer> memo = new HashMap<>();
        String key = Integer.toString(onesCount - zerosCount) + "#" + Integer.toString(twosCount - onesCount);

        memo.put(key, -1);

        for (int i = 0; i < arr.length; i++) {
            int currentValue = arr[i];

            if (currentValue == 0) {
                zerosCount++;
            } else if (currentValue == 1) {
                onesCount++;
            } else {
                twosCount++;
            }

            String currentKey = Integer.toString(onesCount - zerosCount) + "#" + Integer.toString(twosCount - onesCount);

            if (memo.containsKey(currentKey)) {
                int len = i - memo.get(currentKey);
                ans = Math.max(ans, len);
            } else {
                memo.put(currentKey, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}
