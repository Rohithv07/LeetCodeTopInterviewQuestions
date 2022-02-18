Given a grid of size n*m (n is number of rows and m is number of columns grid has) consisting of '0's(Water) and '1's(Land). Find the number of islands.
Note: An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.
 

Example 1:

Input:
grid = {{0,1},{1,0},{1,1},{1,0}}
Output:
1
Explanation:
The grid is-
0 1
1 0
1 1
1 0
All lands are connected.
Example 2:

Input:
grid = {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}}
Output:
2
Expanation:
The grid is-
0 1 1 1 0 0 0
0 0 1 1 0 1 0 
There are two islands one is colored in blue 
and other in orange.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function numIslands() which takes grid as input parameter and returns the total number of islands.
 

Expected Time Compelxity: O(n*m)
Expected Space Compelxity: O(n*m)
 

Constraints:
1 ≤ n, m ≤ 500


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int numberOfIslandCounter = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslandCounter += dfs(grid, i, j);
                }
            }
        }
        return numberOfIslandCounter;
    }
    
    public int dfs(char [][] grid, int currentRow, int currentCol) {
        if (currentRow < 0 || currentCol < 0 || currentRow >= grid.length || currentCol >= grid[0].length || grid[currentRow][currentCol] != '1') {
            return 0;
        }
        grid[currentRow][currentCol] = '.';
        dfs(grid, currentRow - 1, currentCol);
        dfs(grid, currentRow + 1, currentCol);
        dfs(grid, currentRow, currentCol - 1);
        dfs(grid, currentRow, currentCol + 1);
        dfs(grid, currentRow - 1, currentCol - 1);
        dfs(grid, currentRow - 1, currentCol + 1);
        dfs(grid, currentRow + 1, currentCol - 1);
        dfs(grid, currentRow + 1, currentCol + 1);
        return 1;
    }
}