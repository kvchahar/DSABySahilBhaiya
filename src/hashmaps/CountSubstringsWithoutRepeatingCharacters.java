package hashmaps;

import java.util.HashMap;

public class CountSubstringsWithoutRepeatingCharacters {

    public static int substr(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int answer = 0;
        int release = 0;

        for (int acquire = 0; acquire < str.length(); acquire++) {
            char key = str.charAt(acquire);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }

            while (release<=acquire && map.get(key)>1){
                char ch = str.charAt(release);
                int freq = map.get(ch);
                freq--;
                map.put(ch,freq);

                if(freq==0){
                    map.remove(ch);
                }
                release+=1;
            }
            answer += (acquire - release + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        String str = "aabcbcdbca";
        System.out.println(substr(str));
    }
}
