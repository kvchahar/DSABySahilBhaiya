package graph;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        // DFS


//         int m = image.length;
//         int n = image[0].length;
//         int color = image[sr][sc];

//         if(image[sr][sc]==newColor){
//             return image;
//         }

//         modifiedFloodFill(image,sr,sc,m,n,color,newColor);

//         return image;
//     }

//     private void modifiedFloodFill(int[][] image, int sr, int sc, int m, int n, int color, int newColor){

//         if(sr < 0 || sc < 0 || sr >= m || sc >= n || image[sr][sc]!=color){
//             return;
//         }

//         image[sr][sc] = newColor;

//         // for up
//         modifiedFloodFill(image, sr - 1, sc, m, n, color, newColor);

//         // for down
//         modifiedFloodFill(image, sr + 1, sc, m, n, color, newColor);

//         // for right
//         modifiedFloodFill(image, sr, sc + 1, m, n, color, newColor);

//         // for left
//         modifiedFloodFill(image, sr, sc-1, m, n, color, newColor);

//         return;







        // BFS

        int m = image.length;
        int n = image[0].length;

        Queue<Pair> queue = new LinkedList<>();
        int color = image[sr][sc];

        if(image[sr][sc]==newColor){
            return image;
        }

        queue.add(new Pair(sr,sc));

        while(!queue.isEmpty()){
            Pair currentPair = queue.remove();
            int currentRow = currentPair.x;
            int currentCol = currentPair.y;

            if(currentRow < 0 || currentCol < 0 || currentRow >= m || currentCol >= n || image[currentRow][currentCol]!=color){
                continue;
            }

            image[currentRow][currentCol] = newColor;

            queue.add(new Pair(currentRow-1,currentCol));
            queue.add(new Pair(currentRow,currentCol+1));
            queue.add(new Pair(currentRow+1,currentCol));
            queue.add(new Pair(currentRow,currentCol-1));

        }

        return image;
    }
}