There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.

Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.

 

Example 1:


Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
Output: 6
Example 2:


Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
Output: 12
 

Constraints:

1 <= m, n <= 50
0 <= maxMove <= 50
0 <= startRow < m
0 <= startColumn < n


class Solution {
    
    private final int [][] direction = new int [][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private final int MOD = (int)(1e9 + 7);
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // the moves left after reaching cell m, n
        Long [][][] dp = new Long [m][n][maxMove + 1];
        return (int)(dfs(m, n, maxMove, startRow, startColumn, dp) % MOD) % MOD;
    }
    
    private Long dfs(int m, int n, int maxMove, int i, int j, Long [][][] dp) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 1L;
        }
        if (maxMove == 0) {
            return 0L;
        }
        if (dp[i][j][maxMove] != null) {
            return dp[i][j][maxMove];
        }
        dp[i][j][maxMove] = 0L;
        for (int [] dir : direction) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            dp[i][j][maxMove] = (dp[i][j][maxMove] + dfs(m, n, maxMove - 1, x, y, dp) % MOD) % MOD;
        }
        return dp[i][j][maxMove];
    }
}