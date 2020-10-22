https://www.hackerrank.com/challenges/castle-on-the-grid/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        int [][] map = new int [grid.length][grid[0].length()];
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[0].length; j++) {
                map[i][j] = grid[i].charAt(j) == '.' ? -1 : -2;
            }
        }
        map[startX][startY] = 0;
        int step = 0;
        while (true) {
            step += 1;
            for (int i=0; i<map.length; i++) {
                for (int j=0; j<map[0].length; j++) {
                    if (map[i][j] == -1) {
                        expand(map, i, j, step);
                        if (i == goalX && j == goalY && map[i][j] != -1)
                            return step;
                    }
                }
            }
        }
    }
    static void expand(int [][] map, int x, int y, int step) {
        // left
        for (int j=y-1; j>=0 && map[x][j] != -2; j--) {
            if (map[x][j] == step-1)
                map[x][y] = step;
        }
        // right
        for (int j=y+1; j<map[0].length && map[x][j] != -2; j++) {
            if (map[x][j] == step-1)
                map[x][y] = step;
        }
        // top
        for (int i=x-1; i>=0 && map[i][y] != -2; i--) {
            if (map[i][y] ==step-1)
                map[x][y] = step;
        }
        // down
        for (int i=x+1; i<map.length && map[i][y] != -2; i++) {
            if (map[i][y] == step-1)
                map[x][y] = step;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

