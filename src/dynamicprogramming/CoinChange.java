package dynamicprogramming;

import java.util.HashMap;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int res = minimumWays(coins,0,amount,new HashMap<String,Integer>());
        if(res==100000){
            return -1;
        }
        return res;
    }

    public static int minimumWays(int[] coins, int currentIndex, int amount, HashMap<String,Integer> memo){

        if(amount==0){
            return 0;
        }

        if(currentIndex>=coins.length){
            return 100000;
        }

        String currentKey = Integer.toString(currentIndex) + "_" + Integer.toString(amount);

        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }

        int consider = 100000;

        if(coins[currentIndex]<=amount){
            consider = 1 + minimumWays(coins, currentIndex, amount - coins[currentIndex], memo);
        }
        int notConsider = minimumWays(coins, currentIndex + 1, amount, memo);

        memo.put(currentKey, Math.min(consider,notConsider));

        return Math.min(consider, notConsider);
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5},11)); // 3
    }
}
