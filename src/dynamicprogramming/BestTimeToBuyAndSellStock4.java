package dynamicprogramming;

import java.util.HashMap;

class BestTimeToBuyAndSellStock4 {
    public  static int maxProfit(int k,int[] prices) {
        return bestTime(prices,0,true, k, new HashMap<>());
    }

    public static int bestTime(int[] prices, int currentDay, boolean canBuy, int k, HashMap<String,Integer> memo){

        if(currentDay >= prices.length || k<=0){
            return 0;
        }

        String currentKey = Integer.toString(currentDay) + "_"+ Boolean.toString(canBuy) + "_" + Integer.toString(k); ;

        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        int idle = bestTime(prices, currentDay + 1, canBuy, k, memo);

        if(canBuy){
            int buy = -prices[currentDay] + bestTime(prices, currentDay + 1, false, k, memo);
            memo.put(currentKey, Math.max(idle,buy));
        }else{
            int sell = prices[currentDay] + bestTime(prices, currentDay + 1, true, k-1, memo);
            memo.put(currentKey, Math.max(idle,sell));
        }
        return memo.get(currentKey);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(2,new int[]{2,4,1})); // 2
    }
}