class Solution
{
    public int findMaxArea(int[][] grid)
    {
        // Code here
        int row = grid.length;
        if (row == 0)
            return 0;
        int col = grid[0].length;
        int maxArea = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1)
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }
    
    public int dfs(int [][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1)
            return 0;
        grid[i][j] = 0;
        return 1 + dfs(grid, i+1, j) + dfs(grid, i-1, j) + dfs(grid, i, j+1) + dfs(grid, i, j-1) + dfs(grid, i-1, j+1) + dfs(grid, i+1, j-1) + dfs(grid, i-1, j-1) + dfs(grid, i+1, j+1);
    }
}
