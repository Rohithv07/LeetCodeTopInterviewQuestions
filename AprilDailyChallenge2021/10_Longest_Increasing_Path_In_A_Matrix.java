Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 

Example 1:


Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:


Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:

Input: matrix = [[1]]
Output: 1
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1


class Solution {
    
    private int [][] directions = new int [][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int [][] memo = new int [row][col];
        int max = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int currentLength = dfs(matrix, i, j, memo);
                max = Math.max(max, currentLength);
            }
        }
        return max;
    }
    
    public int dfs(int [][] matrix, int i, int j, int [][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int max = 1;
        for (int [] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || matrix[x][y] <= matrix[i][j])
                continue;
            int currentLength = 1 + dfs(matrix, x, y, memo);
            max = Math.max(max, currentLength);
        }
        memo[i][j] = max;
        return max;
    }
}
