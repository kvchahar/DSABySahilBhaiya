package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame3 {
    public boolean canReach(int[] arr, int start) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                int currentIndex = queue.remove();

                // for left traversing

                if (currentIndex - arr[currentIndex] >= 0) {
                    if (arr[currentIndex - arr[currentIndex]] == 0) {
                        return true;
                    } else if (arr[currentIndex - arr[currentIndex]] > 0) {
                        queue.add(currentIndex - arr[currentIndex]);
                    }
                }


                // for right traversing

                if (currentIndex + arr[currentIndex] < arr.length) {
                    if (arr[currentIndex + arr[currentIndex]] == 0) {
                        return true;
                    } else if (arr[currentIndex + arr[currentIndex]] > 0) {
                        queue.add(currentIndex + arr[currentIndex]);
                    }
                }

                arr[currentIndex] = -1; // index visited (to stop the inifinite condition)
            }
        }
        return false;
    }
}