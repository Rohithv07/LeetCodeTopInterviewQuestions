https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs



public class Solution {

    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int region = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1)
                    region = Math.max(region, dfsHelper(grid, i, j));
            }
        }
        return region;
    }
    
    static int dfsHelper(int [][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return 0;
        int count = 1;
        grid[i][j] = 0;
        count += dfsHelper(grid, i+1, j);
        count += dfsHelper(grid, i, j+1);
        count += dfsHelper(grid, i-1, j);
        count += dfsHelper(grid, i, j-1);
        count += dfsHelper(grid, i+1, j+1);
        count += dfsHelper(grid, i+1, j-1);
        count += dfsHelper(grid, i-1, j+1);
        count += dfsHelper(grid, i-1, j-1);
        return count;
    }

