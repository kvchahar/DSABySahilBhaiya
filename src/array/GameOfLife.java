package array;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] copyMatrix = new int[m][n];

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                copyMatrix[i][j] = board[i][j];
            }
        }

        int[] xAxis = {1,1,0,-1,-1,-1,0,1};
        int[] yAxis = {0,1,1,1,0,-1,-1,-1};

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                int countLives = 0;
                for(int k = 0; k<8; k++){
                    if(isValid(i + xAxis[k] , j + yAxis[k],m,n) && copyMatrix[i+xAxis[k]][j+yAxis[k]]==1)
                        countLives++;
                }

                if(copyMatrix[i][j]==1 && countLives<2 || countLives>3)
                    board[i][j] = 0;
                if(copyMatrix[i][j]==0 && countLives==3)
                    board[i][j] = 1;
            }
        }

    }

    private boolean isValid(int currRow, int currCol, int m, int n){
        return (currRow>=0 && currRow<m && currCol>=0 && currCol<n);
    }
}
