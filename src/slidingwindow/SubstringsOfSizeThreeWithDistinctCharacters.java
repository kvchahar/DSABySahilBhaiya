package slidingwindow;

import java.util.HashMap;

public class SubstringsOfSizeThreeWithDistinctCharacters {
    public int countGoodSubstrings(String s) {
        int count = 0;
        int release = 0;
        int distinct = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        int size = s.length();

        if (size < 3) {
            return 0;
        }

        for (int i = 0; i < 2; i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
                distinct += 1;
            }
        }
        for (int acquire = 2; acquire < size; acquire++) {
            char chr = s.charAt(acquire);

            if (map.containsKey(chr)) {
                map.put(chr, map.get(chr) + 1);
            } else {
                map.put(chr, 1);
                distinct++;
            }

            if (distinct == 3) {
                count += 1;
            }

            char discard = s.charAt(release);
            int freq = map.get(discard);
            freq -= 1;
            map.put(discard, freq);
            if (freq == 0) {
                map.remove(discard);
                distinct -= 1;
            }
            release++;
        }
        return count;
    }
}
