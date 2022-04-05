package hashmaps;

public class MaximumSumSubarrayOfSizeK {

    public static int maxSum(int[] arr, int k) {
        int size = arr.length;
        int sum = 0;
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        while (j < size) {
            sum += arr[j];
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                max = Math.max(max, sum);
                sum = sum - arr[i];
                i++;
                j++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {32, 51, 23, 14, 62, 45, 28, 10};
        int k = 3;
        int ans = maxSum(arr, k);
        System.out.println(ans);
    }
}
