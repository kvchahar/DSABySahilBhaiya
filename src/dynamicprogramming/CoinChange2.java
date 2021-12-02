package dynamicprogramming;

import java.util.HashMap;

public class CoinChange2 {
    public static int change(int amount,int[] coins) {
        return minimumWays(coins,0,amount,new HashMap<>());
    }

    public static int minimumWays(int[] coins, int currentIndex, int amount, HashMap<String,Integer> memo){

        if(amount==0){
            return 1;
        }

        if(currentIndex>=coins.length){
            return 0;
        }

        String currentKey = Integer.toString(currentIndex) + "_" + Integer.toString(amount);

        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }

        int consider = 0;

        if(coins[currentIndex]<=amount){
            consider = minimumWays(coins, currentIndex, amount - coins[currentIndex], memo);
        }
        int notConsider = minimumWays(coins, currentIndex + 1, amount, memo);

        memo.put(currentKey, consider+notConsider);

        return consider + notConsider;
    }

    public static void main(String[] args) {
        System.out.println(change(5,new int[]{1,2,5})); // 4
    }
}
