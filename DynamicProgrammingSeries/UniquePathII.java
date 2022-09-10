// https://www.youtube.com/watch?v=TmhpgXScLyY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=10



/*
 The idea is the same one similar to the unique path I problem. Only the change is we have serveral obstacles introduced through which the robot cannot pass.
 
 1. Express in terms of index : here we can express in terms of row and col as the robot can go either down which changes the row and right which changes the column,
 2. Do stuff on index and take the min/max/total ways : 

Here we need total paths. Just introduce an extra base case and yes the problem is done.

The extra case is already provided in the problem that the robot cannot move through the obstacles.
Thats it
if (row >= 0 && col >= 0 && currentCell == 1) just return 0 as there is no more moves possible for the robot.

Memoization solution straight way : 

TC : O(M* N)
SC : O(StackSpace) + O(M * N)

*/



class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        if (obstacleGrid[row - 1][col - 1] == 1) {
            return 0;
        }
        int [][] dp = new int [row][col];
        for (int [] d : dp) {
            Arrays.fill(d, -1);
        }
        return findPath(obstacleGrid, row - 1, col - 1, dp);
    }
    
    private int findPath(int [][] grid, int row, int col, int [][] dp) {
        if (row == 0 && col == 0) {
            return 1;
        }
        if (row >= 0 && col >= 0 && grid[row][col] == 1) {
            return 0;
        }
        if (row < 0 || col < 0) {
            return 0;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int up = findPath(grid, row - 1, col, dp);
        int left = findPath(grid, row, col - 1, dp);
        return dp[row][col] = up + left;
    }
}
/*
Now we can easily do the bottoms up, tabulation method.

1. Start with the base cases and fill the dp table
2. Do the loop through the grid and copy paste the remaining code from the memoization + the extra base condition for the obstacke check
3. Return the last cell value from the dp table

TC : O(M * N)
SC : O(M * N)


*/


class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (grid[0][0] == 1) {
            return 0;
        }
        if (grid[row - 1][col - 1] == 1) {
            return 0;
        }
        int [][] dp = new int [row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }
                else {
                    int up = 0;
                    int left = 0;
                    if (i > 0) {
                        up = dp[i - 1][j];
                    }
                    if (j > 0) {
                        left = dp[i][j - 1];
                    }
                    dp[i][j] = up + left;
                    // this is basically up + left from memo code
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
/*
Now we have the possibilty for the space optimization.

We can do space optimization generally when we are using the previous values or previous previous values for the computation of the current value. No other past values.
Here we are just using the previous row value and the previous column value The previous column value can be easily obtained by taking current[j - 1]
But to get the previous row value, we need to maintain a dp array which only holds the immediate previous row, not any row before that. Just the previous row and this will reduce the space complexity to O(N) where N = col

TC : O(M * N)
SC : O(N)


*/


class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (grid[0][0] == 1) {
            return 0;
        }
        if (grid[row - 1][col - 1] == 1) {
            return 0;
        }
        int [] previousRow = new int [col];
        for (int i = 0; i < row; i++) {
            int [] currentRow = new int [col];
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    currentRow[j] = 0;
                }
                else if (i == 0 && j == 0) {
                    currentRow[j] = 1;
                }
                else {
                    int up = previousRow[j];
                    int left = 0;
                    if (j > 0) {
                        left = currentRow[j - 1];
                    }
                    currentRow[j] = left + up;
                }
            }
            previousRow = currentRow;
        }
        return previousRow[col - 1];
    }
}