package graph;

import java.util.LinkedList;
import java.util.Queue;

class OrangePair {
    int x;
    int y;

    OrangePair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class RottingOranges {
    public int orangesRotting(int[][] grid) {

        Queue<OrangePair> queue = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;
        int totalOranges = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new OrangePair(i, j));
                }
                if (grid[i][j] != 0) {
                    totalOranges++;
                }
            }
        }

        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        int countMin = 0, count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count += size;

            for (int i = 0; i < size; i++) {
                OrangePair currentNode = queue.remove();
                for (int j = 0; j < 4; j++) {
                    int currentRow = currentNode.x + dx[j];
                    int currentCol = currentNode.y + dy[j];

                    if (currentRow < 0 || currentCol < 0 || currentRow >= m || currentCol >= n || grid[currentRow][currentCol] == 0 || grid[currentRow][currentCol] == 2) {
                        continue;
                    }
                    grid[currentRow][currentCol] = 2;
                    queue.offer(new OrangePair(currentRow, currentCol));
                }
            }
            if (queue.size() != 0) {
                countMin++;
            }
        }
        return totalOranges == count ? countMin : -1;
    }
}
