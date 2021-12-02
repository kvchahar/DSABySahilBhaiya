package dynamicprogramming;

public class SubsetSumProblem {

    static boolean isSubsetSum(int n, int[] set, int sum) {
        boolean subset[][] = new boolean[sum + 1][n + 1];

        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        // Fill the subset table in bottom
        // up manner
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1])
                    subset[i][j] = subset[i][j]
                            || subset[i - set[j - 1]][j - 1];
            }
        }
        return subset[sum][n];
    }

    public static void main(String[] args) {
        boolean res = isSubsetSum(6,new int[]{3, 34, 4, 12, 5, 2},9); // true
        System.out.println(res);
    }
}