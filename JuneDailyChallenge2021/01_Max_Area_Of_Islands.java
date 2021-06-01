You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

 

Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.



class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfsHelper(grid, i, j));
                }
            }
        }
        return maxArea;
    }
    
    public int dfsHelper(int [][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;
        return 1 + dfsHelper(grid, i-1, j) + dfsHelper(grid, i+1, j) + dfsHelper(grid, i, j-1) + dfsHelper(grid, i, j+1);
    }
}
