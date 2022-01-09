package recursionandbacktracking;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        sudokuSolver(board, 0, 0);

        return;
    }

    public boolean sudokuSolver(char[][] board, int currentRow, int currentCol) {
        if (currentRow == 9) {
            return true;
        }

        int nextRow = -1;
        int nextCol = -1;
        if (currentCol == 8) {
            nextRow = currentRow + 1;
            nextCol = 0;
        } else {
            nextRow = currentRow;
            nextCol = currentCol + 1;
        }

        if (board[currentRow][currentCol] != '.') {
            return sudokuSolver(board, nextRow, nextCol);
        }

        for (char currentVal = 1; currentVal < 10; currentVal++) {
            if (isValidCell(board, currentRow, currentCol, currentVal)) {
                board[currentRow][currentCol] = (char) (currentVal + '0');

                if (sudokuSolver(board, nextRow, nextCol)) {
                    return true;
                }

                board[currentRow][currentCol] = '.';
            }
        }
        return false;
    }

    public boolean isValidCell(char[][] board, int currentRow, int currentCol, int currentVal) {
        return isRowValid(board, currentRow, currentVal) && isColValid(board, currentCol, currentVal) && isSubGridValid(board, currentRow, currentCol, currentVal);
    }

    public boolean isRowValid(char[][] board, int currentRow, int currentVal) {
        for (int currentCol = 0; currentCol < 9; currentCol++) {
            if (board[currentRow][currentCol] == (char) (currentVal + '0')) {
                return false;
            }
        }
        return true;
    }

    public boolean isColValid(char[][] board, int currentCol, int currentVal) {
        for (int currentRow = 0; currentRow < 9; currentRow++) {
            if (board[currentRow][currentCol] == (char) (currentVal + '0')) {
                return false;
            }
        }
        return true;
    }

    public boolean isSubGridValid(char[][] board, int currentRow, int currentCol, int currentVal) {
        int x = 3 * (currentRow / 3);
        int y = 3 * (currentCol / 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[x + i][y + j] == (char) (currentVal + '0')) {
                    return false;
                }
            }
        }
        return true;
    }

}