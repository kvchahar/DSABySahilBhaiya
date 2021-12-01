package dynamicprogramming;

import java.util.HashMap;

public class PalindromePartitioning2 {
    public int minCut(String s) {
        return minimumWays(s,0,s.length()-1, new HashMap<>());
    }

    public int minimumWays(String str, int start, int end, HashMap<String,Integer> memo){

        if(isPalindrome(str,start,end)==true){
            return 0;
        }

        if(start>end){
            return 0;
        }

        String currentKey = Integer.toString(start) + "_" + Integer.toString(end);
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }

        int ans = 100000;

        for(int current = start; current<end; current++){
            if(isPalindrome(str, start, current) == true){
                int rightHalf = minimumWays(str, current + 1, end,memo);
                ans = Math.min(ans, 1 + rightHalf);
            }
        }
        memo.put(currentKey, ans);
        return ans;
    }

    public boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start = start + 1;
            end = end - 1;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning2 p = new PalindromePartitioning2();
        System.out.println(p.minCut("aab")); // 1
    }
}