package dynamicprogramming;

import java.util.HashMap;

public class DistinctSubsequences {
        public static int numDistinct(String s, String t) {
            return totalWays(0,0,s,t, new HashMap<>());
        }
        public static int totalWays(int currS,int currT, String s, String t, HashMap<String,Integer> memo){
            if(currT==t.length()){
                return 1;
            }

            if(currS==s.length()){
                return 0;
            }

            String currentKey = Integer.toString(currS) + "_" + Integer.toString(currT);

            if(memo.containsKey(currentKey)){
                return memo.get(currentKey);
            }

            int pick = 0;
            if(s.charAt(currS)==t.charAt(currT)) {
                pick = totalWays(currS + 1, currT + 1, s ,t,memo);
            }
            int dontPick = totalWays(currS + 1, currT, s , t,memo);

            memo.put(currentKey,pick + dontPick);
            return pick + dontPick;
        }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(numDistinct(s,t));
    }
}
