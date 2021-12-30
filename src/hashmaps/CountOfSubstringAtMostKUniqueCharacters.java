package hashmaps;

import java.util.HashMap;

public class CountOfSubstringAtMostKUniqueCharacters {
    public static int solution(String str, int k) {
        // write your code here

        int answer = 0;
        int release = 0;

        int distinctElement = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int acquire = 0; acquire < str.length(); acquire++) {
            char currentChar = str.charAt(acquire);

            if (map.containsKey(currentChar)) {
                int value = map.get(currentChar);
                map.put(currentChar, value + 1);
            } else {
                map.put(currentChar, 1);
                distinctElement++;
            }

            while (release <= acquire && distinctElement > k) {
                char discard = str.charAt(release);
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
        String s = "aabcbcdbca";
        int k = 2;
        System.out.println(solution(s,k)); // 23
    }
}
