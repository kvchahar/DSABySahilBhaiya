package dynamicprogramming;

import java.util.HashMap;

public class BestTimeToBuyAndSellStockWithCooldown {
    public static int maxProfit(int[] prices) {
        return bestTime(0, prices, true, new HashMap<>());
    }

    public static int bestTime(int currentDay, int[] prices, boolean canBuy, HashMap<String, Integer> memo) {

        if (currentDay >= prices.length) {
            return 0;
        }

        String currentKey = Integer.toString(currentDay) + "_" + Boolean.toString(canBuy);

        if (memo.containsKey(currentKey)) {
            return memo.get(currentKey);
        }
        int idle = bestTime(currentDay + 1, prices, canBuy, memo);

        if (canBuy) {
            int buy = bestTime(currentDay + 1, prices, false, memo) - prices[currentDay];
            int profit = Math.max(idle, buy);
            memo.put(currentKey, profit);
            return profit;
        } else {
            int sell = bestTime(currentDay + 2, prices, true, memo) + prices[currentDay];
            int profit = Math.max(idle, sell);
            memo.put(currentKey, profit);
            return profit;
        }
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices)); // 3
    }
}
