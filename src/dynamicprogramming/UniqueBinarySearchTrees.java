package dynamicprogramming;

import java.util.HashMap;

class UniqueBinarySearchTrees {
    public static int numTrees(int n) {
        return uniqueBST(n, new HashMap<>());
    }

    public static int uniqueBST(int n, HashMap<Integer,Integer> memo){

        if(n<=1){
            return 1;
        }

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        int ans = 0;
        for(int i = 0; i<n; i++){
            ans += uniqueBST(i,memo) * uniqueBST(n-i-1,memo);
        }

        memo.put(n,ans);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3)); // 5
    }
}