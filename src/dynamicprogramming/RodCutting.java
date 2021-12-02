package dynamicprogramming;

import java.util.HashMap;

public class RodCutting {
    public static int cutRod(int price[], int n) {
        return totalProfit(price,0,n, new HashMap<>());
    }

    public static int totalProfit(int[] price, int currentIndex, int length, HashMap<String,Integer> memo){

        if(length==0){
            return 0;
        }

        if(currentIndex>=price.length){
            return 0;
        }

        String currentKey = Integer.toString(currentIndex) + "_" + Integer.toString(length);
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }

        int currentLength = currentIndex + 1;
        int consider = 0;
        if(currentLength<=length){
            consider = price[currentIndex] + totalProfit(price, currentIndex, length - currentLength,memo);
        }
        int notConsider = totalProfit(price, currentIndex + 1, length,memo);
        memo.put(currentKey, Math.max(consider,notConsider));
        return Math.max(consider , notConsider);
    }

    public static void main(String[] args) {
        System.out.println(cutRod(new int[]{1, 5, 8, 9, 10, 17, 17, 20},8)); // 22
    }
}
