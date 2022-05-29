Given a n*m matrix, find the maximum length path (starting from any cell) such that all cells along the path are in strictly increasing order.

We can move in 4 directions from a given cell (i, j), i.e., we can move to (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1).
 

Example 1:

Input: matrix = {{1,2,9},{5,3,8},{4,6,7}}
Output: 7
Explanation: The longest increasing path is
{1,2,3,6,7,8,9}.
Example 2:

Input: matrix = {{3,4,5},{3,2,6},{2,2,1}}
Output: 4
Explanation: The longest increasing path is
{3,4,5,6}.
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function longestIncreasingPath() which takes matrix as input parameter and returns the length of the lonest increasing path.

Expected Time Complexity: O(n*m)
Expected Space Comeplxity: O(n*m)
 

Constraints:
1 <= n, m <= 100
1 <= matrix[i][j] <= 104


class Solution
{
    private int [][] direction = new int [][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int longestIncreasingPath(int[][] matrix)
    {
        // Code here 
        int row = matrix.length;
        int col = matrix[0].length;
        int [][] dp = new int [row][col];
        for (int [] mat : dp) {
            Arrays.fill(mat, -1);
        }
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int currentLength = dfs(matrix, dp, i, j);
                max = Math.max(max, currentLength);
            }
        }
        return max + 1;
    }
    
    private int dfs(int [][] matrix, int [][] dp, int i, int j) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int runningLength = 0;
        for (int [] dir : direction) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            int length = 1 + dfs(matrix, dp, x, y);
            runningLength = Math.max(runningLength, length);
        }
        return dp[i][j] = runningLength;
    }
}