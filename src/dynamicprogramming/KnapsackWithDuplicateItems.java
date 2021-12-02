package dynamicprogramming;

import java.util.Arrays;

public class KnapsackWithDuplicateItems {
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int[][] dp = new int[N+1][W+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return maxProfit(N,0,W,val,wt,dp);
    }

    public static int maxProfit(int N, int currentIndex, int weight, int[] val,int[] wt,int[][] memo){

        if(currentIndex>=N){
            return 0;
        }

        if(memo[currentIndex][weight]!=-1){
            return memo[currentIndex][weight];
        }


        int consider = 0;
        if(wt[currentIndex]<=weight){
            consider = val[currentIndex] + maxProfit(N,currentIndex,weight - wt[currentIndex],val,wt, memo);
        }
        int notConsider = maxProfit(N,currentIndex + 1, weight, val, wt, memo);
        int ans = (int)(Math.max(consider,notConsider));

        memo[currentIndex][weight] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int ans = knapSack(2,3,new int[]{1,1},new int[]{2,1});
        System.out.println(ans); // 3
    }
}
