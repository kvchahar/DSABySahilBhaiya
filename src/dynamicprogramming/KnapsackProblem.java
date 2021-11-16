package dynamicprogramming;

import java.util.HashMap;

public class KnapsackProblem {
    public static int knapsack(int capacity, int weight[], int values[], int size){
        return maxProfit(0,capacity,weight,values,size, new HashMap<>());
    }

    public static int maxProfit(int currentItem, int currentCapacity,int[] weight,int[] values,int size,
                                HashMap<String,Integer> memo){
        if(currentItem>=size){
            return 0;
        }

        String currentKey = Integer.toString(currentItem) + "_" + Integer.toString(currentCapacity);

        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }

        int consider = 0;
        if(weight[currentItem]<=currentCapacity) {

            consider = values[currentItem] + maxProfit(currentItem + 1,
                    currentCapacity - weight[currentItem], weight, values, size,memo);
        }
        int notConsider = maxProfit(currentItem+1,
                currentCapacity,weight,values,size,memo);

        int total = Math.max(consider,notConsider);
        memo.put(currentKey,total);

        return total;
    }

    public static void main(String[] args) {
        int[] values = {1,2,3};
        int[] weight = {4,5,1};
        int N = values.length;
        int capacity = 4;
        System.out.println(knapsack(capacity,weight,values,N));
    }
}
