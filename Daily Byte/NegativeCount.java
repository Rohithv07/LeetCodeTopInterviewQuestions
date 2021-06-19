/*
Given an MxN matrix, which is sorted in decreasing order (row-wise and column-wise), return the total number of negative values in the array.

Ex: Given the following matrix…

matrix = [
  [3, -1],
  [2, -2]
], return 2 (-1 and -2 are negative).
Ex: Given the following matrix…

matrix = [
  [4, 3],
  [2, 1]
], return 0.
*/

class Solution {
    public int countNegatives(int[][] grid) {
        // O(m * n)
        // if (grid == null || grid.length == 0)
        //     return 0;
        // int row = grid.length;
        // int col = grid[0].length;
        // int count = 0;
        // for (int i=0; i<row; i++) {
        //     for (int j=col-1; j>=0; j--) {
        //         if (grid[i][j] < 0)
        //             count += 1;
        //         else
        //             break;
        //     }
        // }
        // return count;
        
        
        // O(m + n) solution
        if (grid == null || grid.length == 0)
            return 0;
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        int i = 0;
        int j = col - 1;
        while (i < row && j >= 0) {
            if (grid[i][j] < 0) {
                j--;
                count += row - i;
            }
            else {
                i += 1;
            }
        }
        return count;
    }
}
