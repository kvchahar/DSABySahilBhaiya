package recursionandbacktracking;

import java.util.Scanner;

public class KnightTour {

    private static void knightTour(int[][] grid, int currentRow, int currentCol, int upcomingMove, int n) {

        if (currentRow < 0 || currentCol < 0 || currentCol >= n || currentRow >= n || grid[currentRow][currentCol] != 0) {
            return;
        }


        if (upcomingMove == (n * n)-1) {
            grid[currentRow][currentCol] = upcomingMove;
            displayResult(grid);
            grid[currentRow][currentCol] = 0;
            return;
        }



        grid[currentRow][currentCol] = upcomingMove;

        knightTour(grid, currentRow - 2, currentCol + 1, upcomingMove + 1, n);
        knightTour(grid, currentRow - 2, currentCol - 1, upcomingMove + 1, n);
        knightTour(grid, currentRow + 2, currentCol + 1, upcomingMove + 1, n);
        knightTour(grid, currentRow + 2, currentCol - 1, upcomingMove + 1, n);
        knightTour(grid, currentRow - 1, currentCol + 2, upcomingMove + 1, n);
        knightTour(grid, currentRow - 1, currentCol - 2, upcomingMove + 1, n);
        knightTour(grid, currentRow + 1, currentCol + 2, upcomingMove + 1, n);
        knightTour(grid, currentRow + 1, currentCol - 2, upcomingMove + 1, n);

        grid[currentRow][currentCol] = 0;
        return;
    }

    private static void displayResult(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter rows-column number");
        int n = 4;
        int[][] grid = new int[n][n];
//        System.out.println("Enter current row");
//        int row = sc.nextInt();
//        System.out.println("Enter current column");
//        int column = sc.nextInt();
//        System.out.println("Enter upcoming move");
//        int upcomingMove = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                knightTour(grid, i, j, 0, n);
            }
        }

        displayResult(grid);
    }
}
