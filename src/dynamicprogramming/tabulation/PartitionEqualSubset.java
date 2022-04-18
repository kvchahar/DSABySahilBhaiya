package dynamicprogramming.tabulation;

public class PartitionEqualSubset {
    public boolean canPartition(int[] arr) {

        int totSum = 0;

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        if (totSum % 2 == 1) return false;

        else {
            int k = totSum / 2;
            boolean dp[][] = new boolean[n][k + 1];

            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }

            if (arr[0] <= k)
                dp[0][arr[0]] = true;

            for (int ind = 1; ind < n; ind++) {
                for (int target = 1; target <= k; target++) {

                    boolean notTaken = dp[ind - 1][target];

                    boolean taken = false;
                    if (arr[ind] <= target)
                        taken = dp[ind - 1][target - arr[ind]];

                    dp[ind][target] = notTaken || taken;
                }
            }
            return dp[n - 1][k];
        }

    }
}
//    Time Complexity: O(N*K) +O(N)
//    Reason: There are two nested loops that account for O(N*K) and at starting we are running a for loop to calculate totSum.
//
//    Space Complexity: O(N*K)
//    Reason: We are using an external array of size ‘N*K’. Stack Space is eliminated.
