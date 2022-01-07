package recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answers = new ArrayList<>();
        char[][] grid = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }

        NQueens(0, grid, n, answers);

        return answers;
    }


    private void NQueens(int currentRow, char[][] grid, int n, List<List<String>> answers) {
        if (currentRow == n) {
            List<String> tempAns = populateAnswer(grid, n);
            answers.add(tempAns);
            return;
        }


        for (int currentCol = 0; currentCol < n; currentCol++) {
            if (isValid(currentRow, currentCol, grid, n)) {
                grid[currentRow][currentCol] = 'Q';
                NQueens(currentRow + 1, grid, n, answers);
                grid[currentRow][currentCol] = '.';
            }
        }
        return;
    }


    private boolean isValid(int currentRow, int currentCol, char[][] grid, int n) {
        return isRowValid(currentRow, grid, n) && isColumnValid(currentCol, grid, n) && areDiagonalsValid(currentRow, currentCol, grid, n);
    }

    private boolean isRowValid(int currentRow, char[][] grid, int n) {
        for (int j = 0; j < n; j++) {
            if (grid[currentRow][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private boolean isColumnValid(int currentCol, char[][] grid, int n) {
        for (int i = 0; i < n; i++) {
            if (grid[i][currentCol] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private boolean areDiagonalsValid(int currentRow, int currentCol, char[][] grid, int n) {
        int i = currentRow;
        int j = currentCol;

        while (i >= 0 && j >= 0) {
            if (grid[i][j] == 'Q') {
                return false;
            }
            i -= 1;
            j -= 1;
        }

        i = currentRow;
        j = currentCol;

        while (i >= 0 && j < n) {
            if (grid[i][j] == 'Q') {
                return false;
            }
            i -= 1;
            j += 1;
        }

        i = currentRow;
        j = currentCol;

        while (i < n && j < n) {
            if (grid[i][j] == 'Q') {
                return false;
            }
            i += 1;
            j += 1;
        }

        i = currentRow;
        j = currentCol;

        while (i < n && j >= 0) {
            if (grid[i][j] == 'Q') {
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }

    private List<String> populateAnswer(char[][] grid, int n) {
        List<String> tempAns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = 0; j < n; j++) {
                s += grid[i][j];
            }
            tempAns.add(s);
        }
        return tempAns;
    }
}
