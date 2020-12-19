class Solution {
    public int cherryPickup(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Integer [][][] dp = new Integer[row][col][col];
        return dfs(grid, row, col, 0, 0, col-1, dp);
    }
    public int dfs(int [][] grid, int m, int n, int r, int c1, int c2, Integer[][][] dp) {
        if (r == m)
            return 0;
        if (dp[r][c1][c2] != null)
            return dp[r][c1][c2];
        int answer = 0;
        for (int i=-1; i<=1; i++) {
            for (int j=-1; j<=1; j++) {
                int robo1 = i + c1;
                int robo2 = j + c2;
                if (robo1 >= 0 && robo1 < n && robo2 >= 0 && robo2 < n)
                    answer = Math.max(answer, dfs(grid, m, n, r+1, robo1, robo2, dp));
            }
        }
        int cherry = c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2];
        return dp[r][c1][c2] = answer + cherry;
    }
}
