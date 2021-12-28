package hashmaps;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int answer = 0;

        int leftPointer = 0;

        HashMap<Character,Integer> map = new HashMap<>();
        for(int right = 0; right<s.length(); right++){
            char ch = s.charAt(right);

            if(map.containsKey(ch) && map.get(ch)>=leftPointer){
                leftPointer = map.get(ch) + 1;
            }

            int length = right - leftPointer + 1;
            map.put(ch,right);
            answer = Math.max(answer,length);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
    }
}
