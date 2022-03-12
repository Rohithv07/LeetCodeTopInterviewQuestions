You are given a matrix having n rows and m columns. The special property of this matrix is that some of the cells of this matrix are blocked i.e. they cannot be reached. Now you have to start from the cell (1,1) and reach the end (n,m) provided during the journey you can move horizontally right from the current cell or vertically down from the current cell. Can you answer the number of ways you can traverse the matrix obeying the above constraints starting from (1,1) and ending at (n,m).
 

Example 1:

Input: n = 3, m = 3, k = 2,
blocked_cells = {{1,2},{3,2}}.
Output: 1
Explanation: There is only one path from
(1,1) to(3,3) which is (1,1)->(2,1)->(2,2)->
(2,3)->(3,3).
Example 2:

Input: n = 5, m = 5, k = 1,
blocked_cells = {{5,5}}
Output: 0
Explanation: There is no path to reach at 
(5,5) beacuse (5,5) is blocked.
 

Your Task:
You don't need to read or print anything, Your task is to complete the function FindWays() which takes n, m and blocked_cells as input parameter and returns total number of ways to reach at (n, m) modulo 109 + 7.
 

Expected Time Complexity: O(n*m)
Expected Space Complexity: O(n*m)
 

Constraints:
1 <= n, m <= 500
1 <= k <= n*m 





//User function Template for Java

class Solution
{
    public int FindWays(int n, int m, int[][] blocked_cells)
    {
        // Code here
        int [][] dp = new int [n][m];
        int MOD = (int)(1e9 + 7);
        for (int [] row : dp) {
            Arrays.fill(row, 1);
        }
        for (int [] block : blocked_cells) {
            dp[block[0] - 1][block[1] - 1] = 0;
        }
        boolean isBlocked = false;
        for (int i = 0; i < n; i++) {
            if (dp[i][0] == 0 || isBlocked) {
                isBlocked = true;
                dp[i][0] = 0;
            }
        }
        isBlocked = false;
        for (int i = 0; i < m; i++) {
            if (dp[0][i] == 0 || isBlocked) {
                isBlocked = true;
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] != 0)
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }
        return dp[n - 1][m - 1];
    }
}