Given two integers m & n, find the number of possible sequences of length n such that each of the next element is greater than or equal to twice of the previous element but less than or equal to m.


Example 1:

Input: m = 10, n = 4
Output: 4
Explaination: There should be n elements and 
value of last element should be at-most m. 
The sequences are {1, 2, 4, 8}, {1, 2, 4, 9}, 
{1, 2, 4, 10}, {1, 2, 5, 10}.

Example 2:

Input: m = 5, n = 2
Output: 6
Explaination: The sequences are {1, 2}, 
{1, 3}, {1, 4}, {1, 5}, {2, 4}, {2, 5}.

Your Task:
You do not need to read input or print anything. Your task is to complete the function numberSequence() which takes the number m and n as input parameters and returns the number of sequences.


Expected Time Complexity: O(m*n)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ m, n ≤ 100




class Solution{
    static int numberSequence(int m, int n)
    {
        // code here
        
        // using recursion
        if (m < n)
            return 0;
        if (n == 0)
            return 1;
        return numberSequence(m/2, n-1) + numberSequence(m - 1, n);
        
        
        // using dp table
        int [][] dp = new int [m + 1][n + 1];
        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                // skips the upper triangle;
                else if (i < j)
                    dp[i][j] = 0;
                else if (j == 1)
                    dp[i][j] = i;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i / 2][j - 1];
            }
        }
        return dp[m][n];
    }
}