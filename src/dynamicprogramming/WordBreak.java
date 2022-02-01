package dynamicprogramming;

import java.util.*;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return true;

        Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        int n = s.length();
        boolean[] canWordBreak = new boolean[n];
        for(int i = 0; i < n; i++){
            canWordBreak[i] = set.contains(s.substring(0, i + 1));
            for(int j = 0; j < i; j++){
                if(canWordBreak[j] && set.contains(s.substring(j + 1, i + 1))){
                    canWordBreak[i] = true;
                    break;
                }
            }
        }

        return canWordBreak[n - 1];
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String s = "applepenapple";
        list.addAll(Arrays.asList("apple","pen","apple"));
        System.out.println(wordBreak(s,list));
//        list.addAll(Arrays.asList("apple","pen"));
//        list.addAll(Arrays.asList("cats","dog","sand","and","cat"));
    }
}
