package hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<HashMap<Character, Integer>, List<String>> res = new HashMap<>();

        for (String str : strs) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
            }

            if (!res.containsKey(map)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                res.put(map, list);
            } else {
                List<String> list = res.get(map);
                list.add(str);
            }
        }

        List<List<String>> list = new ArrayList<>();
        for (List val : res.values()) {
            list.add(val);
        }

        return list;
    }

    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(str));
    }
}
