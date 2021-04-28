A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid.

 

Example 1:


Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:


Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 

Constraints:

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.




class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (grid[0][0] == 1)
            return 0;
        grid[0][0] = 1;
        // row
        for (int i=1; i<row; i++) {
            if (grid[i][0] == 0 && grid[i - 1][0] == 1)
                grid[i][0] = 1;
            else
                grid[i][0] = 0;
        }
        // col
        for (int j=1; j<col; j++) {
            if (grid[0][j] == 0 && grid[0][j - 1] == 1)
                grid[0][j] = 1;
            else
                grid[0][j] = 0;
        }
        for (int i=1; i<row; i++) {
            for (int j=1; j<col; j++) {
                if (grid[i][j] != 1) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }
                else
                    grid[i][j] = 0;
            }
        }
        return grid[row - 1][col - 1];
    }
}
