There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent four cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.

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
0 <= startRow <= m
0 <= startColumn <= n


class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod = (int) 1e9 + 7;
        int [][] directions = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Long [][][] dp = new Long [m][n][maxMove + 1];
        return (int) (dfs(m, n, maxMove, startRow, startColumn, mod, directions, dp) % mod);
    }
    
    public long dfs(int m, int n, int maxMove, int i, int j, int mod, int [][] directions, Long [][][] dp) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return 1L;
        if (maxMove == 0)
            return 0L;
        if (dp[i][j][maxMove] != null)
            return dp[i][j][maxMove];
        dp[i][j][maxMove] = 0L;
        for (int [] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            dp[i][j][maxMove] = (dp[i][j][maxMove] + dfs(m, n, maxMove-1, x, y, mod, directions, dp) % mod) % mod;
        }
        return dp[i][j][maxMove];
    }
}
