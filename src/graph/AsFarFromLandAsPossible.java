package graph;

import java.util.LinkedList;
import java.util.Queue;

class RowCol {
    int x;
    int y;

    RowCol(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        Queue<RowCol> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new RowCol(i, j));
                }
            }
        }

        int distance = -1;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        if (queue.size() == 0 || queue.size() == grid.length * grid[0].length) {
            return -1;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                RowCol currentNode = queue.remove();
                for (int j = 0; j < 4; j++) {
                    int currentRow = currentNode.x + dx[j];
                    int currentCol = currentNode.y + dy[j];

                    if (currentRow < 0 || currentCol < 0 || currentRow >= grid.length || currentCol == grid.length || grid[currentRow][currentCol] == 1)
                        continue;


                    queue.add(new RowCol(currentRow, currentCol));
                    grid[currentRow][currentCol] = 1;
                }

            }
        }

        return distance;
    }
}
