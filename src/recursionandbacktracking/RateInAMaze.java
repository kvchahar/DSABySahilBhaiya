package recursionandbacktracking;

import java.util.ArrayList;
import java.util.Collections;

public class RateInAMaze {
    public ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> answers = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        totalWays(0,0,m,n,answers, visited, "");

        Collections.sort(answers);

        return answers;
    }

    public  void totalWays(int currRow, int currColumn, int[][] grid,int n,
                           ArrayList<String> answers, boolean visited[][], String paths){

        if(currRow<0 || currColumn<0 || currRow==n || currColumn==n || visited[currRow][currColumn] ||grid[currRow][currColumn]==0){
            return;
        }

        if(currRow==n-1 && currColumn==n-1){
            answers.add(paths);
            return;
        }

        visited[currRow][currColumn] = true;
        totalWays(currRow-1,currColumn,grid,n,answers,visited, paths + "U");
        totalWays(currRow,currColumn-1,grid,n,answers,visited, paths + "L");
        totalWays(currRow+1,currColumn,grid,n,answers,visited, paths + "D");
        totalWays(currRow,currColumn+1,grid,n,answers,visited, paths + "R");
        visited[currRow][currColumn] = false;

        return;
    }
}