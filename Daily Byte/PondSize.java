You are given two-dimensional matrix that represents a plot of land. Within the matrix there exist two values: ones which represent land and zeroes which represent water within a pond. Given that parts of a pond can be connected both horizontally and vertically (but not diagonally), return the largest pond size.
Note: You may assume that each zero within a given pond contributes a value of one to the total size of the pond.

Ex: Given the following plot of land…

land = [
    [1,1,1],
    [1,0,1],
    [1,1,1]
], return 1.
Ex: Given the following plot of land…

land = [
    [1,0,1],
    [0,0,0],
    [1,0,1]
], return 5.


import java.util.*;

public class PondSize {

    public static int findPondSize(int [][] matrix, int row, int col) {
        int total = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] == 0) {
                    // System.out.println(dfs(matrix, i, j));
                    total = Math.max(total, dfs(matrix, i, j));
                }
                    
            }
        }
        return total;
    }
    public static int dfs(int [][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 1)
            return 0;
        int total = 1;
        int temp = matrix[i][j];
        matrix[i][j] = 1;
        total += dfs(matrix, i-1, j);
        total += dfs(matrix, i+1, j);
        total += dfs(matrix, i, j-1);
        total += dfs(matrix, i, j+1);
        return total;
    }

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int [][] matrix = new int [row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(findPondSize(matrix, row, col));
    }
}
