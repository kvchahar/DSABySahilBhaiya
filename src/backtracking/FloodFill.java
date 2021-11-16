package pepcoding.backtracking.part1;

import java.util.Scanner;

public class FloodFill {
    public static void floodFill(int[][] maze, int row, int column, String pathSoFar, boolean[][] visited) {
        if (row < 0 || column < 0 || row == maze.length || column == maze[0].length || maze[row][column] == 1 || visited[row][column] == true) {
            return;
        }
        if (row == maze.length - 1 && column == maze[0].length - 1) {
            System.out.println(pathSoFar);
            return;
        }

        visited[row][column] = true;
        floodFill(maze, row - 1, column, pathSoFar + "t", visited);
        floodFill(maze, row, column - 1, pathSoFar + "l", visited);
        floodFill(maze, row + 1, column, pathSoFar + "d", visited);
        floodFill(maze, row, column + 1, pathSoFar + "r", visited);
        visited[row][column] = false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] maze = {
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 0}
        };
        int row = 0;
        int column = 0;
        String pathSoFar = "";
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        floodFill(maze, row, column, pathSoFar, visited);
    }
}
