package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstNegativeNumberInEveryWindowOfSizeK {
    public static long[] printFirstNegativeInteger(long A[], int N, int K) {
        List<Long> list = new ArrayList<>();
        long[] res = new long[N - K + 1];

        int acq = 0;
        int rel = 0;
        int idx = 0;

        while (rel < N) {
            if (A[rel] < 0) {
                list.add(A[rel]);
            }
            if (rel - acq + 1 == K) {
                if (list.size() == 0) {
                    res[idx++] = 0;
                } else {
                    res[idx++] = list.get(0);
                    if (A[acq] == list.get(0)) {
                        list.remove(0);
                    }
                }
                acq++;
            }
            rel++;
        }
        return res;
    }

    public static void main(String[] args) {
        long[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int n = arr.length;
        int k = 3;
        System.out.println(Arrays.toString(printFirstNegativeInteger(arr, n, k))); // -1,-1,-7,-15,-15,0
    }
}
