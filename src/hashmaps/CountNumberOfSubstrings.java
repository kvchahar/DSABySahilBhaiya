package hashmaps;

import java.util.HashMap;

public class CountNumberOfSubstrings {
     static long substrCount (String str, int k) {
        return (countAtMostKSubstr(str,k) - countAtMostKSubstr(str,k-1));
    }

    static long countAtMostKSubstr(String str, int k) {
        // write your code here

        long answer = 0;
        int release = 0;

        int distinctElement = 0;

        HashMap<Character, Long> map = new HashMap<>();

        for (int acquire = 0; acquire < str.length(); acquire++) {

            char currentChar = str.charAt(acquire);

            if (map.containsKey(currentChar)) {
                long value = map.get(currentChar);
                map.put(currentChar, value + 1);
            } else {
                map.put(currentChar, 1L);
                distinctElement++;
            }

            while (release <= acquire && distinctElement > k) {
                char discard = str.charAt(release);
                long key = map.get(discard);
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
        String S = "abc";
        int K = 1;
        System.out.println(substrCount(S,K)); // 7
    }
}
