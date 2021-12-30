package hashmaps;

import java.util.HashMap;

public class SubarraysWithKDifferentIntegers {
     static int subarraysWithKDistinct(int[] nums, int k) {
        return (countAtMostKSubstr(nums,k) - countAtMostKSubstr(nums,k-1));
    }

    public static int countAtMostKSubstr(int[] nums, int k) {

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

    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1,2,1,2,3},2)); // 7
    }
}
