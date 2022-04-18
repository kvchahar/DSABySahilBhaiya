package dynamicprogramming.tabulation;

public class SubsetSumProblem {

    static boolean subsetSumUtil(int n, int sum, int[] set) {

        boolean dp[][] = new boolean[n][sum + 1];

        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        // Fill the subset table in bottom
        // up manner

        if (set[0] <= sum) {
            dp[0][set[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean notTaken = dp[i - 1][j];
                boolean taken = false;
                if (j >= set[i]) {
                    taken = dp[i - 1][j - set[i]];
                }
                dp[i][j] = taken || notTaken;
            }
        }
        return dp[n - 1][sum];
    }

    static boolean isSubsetSum(int n, int[] arr, int k) {

        return subsetSumUtil(n, k, arr);
    }
}

//        Time Complexity: O(N*K)
//
//        Reason: There are two nested loops
//
//        Space Complexity: O(N*K)
//
//        Reason: We are using an external array of size ‘N*K’. Stack Space is eliminated.