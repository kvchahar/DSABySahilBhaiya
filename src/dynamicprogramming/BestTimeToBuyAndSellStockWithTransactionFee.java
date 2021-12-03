package dynamicprogramming;

import java.util.HashMap;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static int maxProfit(int[] prices, int fee) {
        return bestTime(prices, 0, true, fee, new HashMap<>());
    }
    public static int bestTime(int[] prices, int currentDay, boolean canBuy, int fee, HashMap<String,Integer> memo){

        if(currentDay >= prices.length){
            return 0;
        }

        String currentKey = Integer.toString(currentDay) + "_"+ Boolean.toString(canBuy);

        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        int idle = bestTime(prices, currentDay + 1, canBuy, fee, memo);

        if(canBuy){
            int buy = -prices[currentDay] + bestTime(prices, currentDay + 1, false, fee, memo);
            memo.put(currentKey, Math.max(idle,buy));
        }else{
            int sell = prices[currentDay] + bestTime(prices, currentDay + 1, true, fee, memo) - fee;
            memo.put(currentKey, Math.max(idle,sell));
        }
        return memo.get(currentKey);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,3,2,8,4,9},2));// 8
    }
}
