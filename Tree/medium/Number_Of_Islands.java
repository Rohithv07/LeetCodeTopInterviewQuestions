Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Solution:

class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null)
            return 0;
        int numberOfIslands = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (grid[i][j] == '1')
                    numberOfIslands += dfsHelper(grid, i, j);
            }
        }
        return numberOfIslands;
    }
    public int dfsHelper(char [][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0')
            return 0;
        grid[i][j] = '0';
        dfsHelper(grid, i+1, j);
        dfsHelper(grid, i-1, j);
        dfsHelper(grid, i, j+1);
        dfsHelper(grid, i, j-1);
        return 1;
    }
}
