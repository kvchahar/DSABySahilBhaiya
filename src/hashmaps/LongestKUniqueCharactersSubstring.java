package hashmaps;

import java.util.HashMap;

public class LongestKUniqueCharactersSubstring {
    public static int longestkSubstr(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int answer = -1;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                int val = map.get(ch);
                int freq = val + 1;
                map.put(ch, freq);
            } else {
                map.put(ch, 1);
            }

            while (left <= right && map.size() > k) {
                char discardChar = s.charAt(left);
                int count = map.get(discardChar);
                count -= 1;
                map.put(discardChar, count);
                left += 1;

                if (map.get(discardChar) == 0) {
                    map.remove(discardChar);
                }
            }

            if (map.size() == k) {
                answer = Math.max(answer, right - left + 1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(longestkSubstr("aabacbebebe",3)); // 7
    }
}
