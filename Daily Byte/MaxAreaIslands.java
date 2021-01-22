/*
Given a 2D array grid, where zeroes represent water and ones represent land, return the size of the largest island.
Note: An island is one or more cells in grid containing a value of one that may be connected vertically or horizontally. Each cell in an island contributes a value of one to the current island’s size.

Ex: Given the following grid...

grid = [
  [1, 1, 0],
  [1, 1, 0],
  [0, 0, 1],
], return 4.


*/




class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        if (grid.length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }
    
    public int dfs(int [][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1)
            return 0;
        grid[i][j] = 0;
        return 1 + dfs(grid, i+1, j) + dfs(grid, i-1, j) + dfs(grid, i, j-1) + dfs(grid, i, j+1);
    }
}