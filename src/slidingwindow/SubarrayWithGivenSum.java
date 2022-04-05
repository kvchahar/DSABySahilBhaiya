package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayWithGivenSum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        int release = 1;
        int acquired = 1;

        int sum = arr[0];

        while (release < n || sum >= s) {
            if (sum == s) {
                return new ArrayList<>(Arrays.asList(acquired, release));
            } else if (sum > s) {
                sum = sum - arr[acquired - 1];
                acquired++;
            } else if (sum < s) {
                release++;
                sum += arr[release - 1];
            }
        }
        return new ArrayList<Integer>(Arrays.asList(-1));
    }

    public static void main(String[] args) {
        int n = 5;
        int s = 12;
        int[] arr = {1, 2, 3, 7, 5};
        System.out.println(subarraySum(arr, n, s));
    }
}
