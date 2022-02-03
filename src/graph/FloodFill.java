package graph;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int color = image[sr][sc];

        if(image[sr][sc]==newColor){
            return image;
        }

        modifiedFloodFill(image,sr,sc,m,n,color,newColor);

        return image;
    }

    private void modifiedFloodFill(int[][] image, int sr, int sc, int m, int n, int color, int newColor){

        if(sr < 0 || sc < 0 || sr >= m || sc >= n || image[sr][sc]!=color){
            return;
        }

        image[sr][sc] = newColor;

        // for up
        modifiedFloodFill(image, sr - 1, sc, m, n, color, newColor);

        // for down
        modifiedFloodFill(image, sr + 1, sc, m, n, color, newColor);

        // for right
        modifiedFloodFill(image, sr, sc + 1, m, n, color, newColor);

        // for left
        modifiedFloodFill(image, sr, sc-1, m, n, color, newColor);

        return;
    }
}