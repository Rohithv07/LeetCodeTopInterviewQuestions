The task is to count all the possible paths from top left to bottom right of a m X n matrix with the constraints that from each cell you can either move only to right or down.

Example 1:

Input: m = 2, n = 2
Output: 2 
Explanation: Two possible ways are
RD and DR.  

Example 2:

Input: m = 3, R = 3
Output: 6
Explanation: Six possible ways are
RRDD, DDRR, RDDR, DRRD, RDRD, DRDR. 

Your Task:  
You dont need to read input or print anything. Complete the function numberOfPaths() which takes m and n as input parameter and returns count all the possible paths.The answer may be very large, compute the answer modulo 109 + 7.


Expected Time Complexity: O(m*n)
Expected Auxiliary Space: O(m*n)

Constraints:
1 <= m <=100
1 <= n <=100


//User function Template for Java
class Solution
{
    long numberOfPaths(int m, int n)
    {
        // code here
        long [][] dp = new long [m][n];
        long MOD = (long)(1e9 + 7);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1l;
                }
                else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                }
            }
            
        }
        return dp[m - 1][n - 1] % MOD;
    }
}