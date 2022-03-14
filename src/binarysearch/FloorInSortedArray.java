package binarysearch;

public class FloorInSortedArray {
    static int findFloor(long arr[], int n, long x)
    {
        int start = 0;
        int end = n - 1;
        int answer = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == x) {
                return mid;

            }
            if (arr[mid] < x) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }

}
