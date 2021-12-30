package hashmaps;

import java.util.HashMap;

public class EquivalentSubArrays {
    int countDistinctSubarray(int[] arr, int n) {

        int k = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i] + 1));
            } else {
                map.put(arr[i], 1);
                k += 1;
            }
        }
        return (countAtMostKSubstr(arr, k) - countAtMostKSubstr(arr, k - 1));
    }

    public int countAtMostKSubstr(int[] nums, int k) {

        int answer = 0;
        int release = 0;

        int distinctElement = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int acquire = 0; acquire < nums.length; acquire++) {
            int currentChar = nums[acquire];

            if (map.containsKey(currentChar)) {
                int value = map.get(currentChar);
                map.put(currentChar, value + 1);
            } else {
                map.put(currentChar, 1);
                distinctElement++;
            }

            while (release <= acquire && distinctElement > k) {
                int discard = nums[release];
                int key = map.get(discard);
                key -= 1;
                map.put(discard, key);
                release++;

                if (key == 0) {
                    map.remove(discard);
                    distinctElement--;
                }
            }
            answer += (acquire - release + 1);

        }
        return answer;
    }
}
