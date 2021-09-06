The problem is to count all the possible paths from top left to bottom right of a MxN matrix with the constraints that from each cell you can either move to right or down.

Example 1:

Input:
M = 3 and N = 3
Output: 6
Explanation:
Let the given input 3*3 matrix is filled 
as such:
A B C
D E F
G H I
The possible paths which exists to reach 
'I' from 'A' following above conditions 
are as follows:ABCFI, ABEHI, ADGHI, ADEFI, 
ADEHI, ABEFI
 

Example 2:

Input:
M = 2 and N = 8
Output: 8

Your Task:  
You don't need to read input or print anything. Your task is to complete the function numberOfPaths() which takes the integer M and integer N as input parameters and returns the number of paths..

Expected Time Complexity: O(m + n - 1))
Expected Auxiliary Space: O(1)


class Solution{
    
    long numberOfPaths(int m, int n) {
        // Code Here
        long [][] dp = new long [m + 1][n + 1];
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (i == 1 || j == 1) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
    
}



class Solution{
    
    long numberOfPaths(int m, int n) {
        // Code Here
        if (m == 1 || n == 1) {
            return 1;
        }
        return numberOfPaths(m-1, n) + numberOfPaths(m, n-1);
    }
    
}

class Solution{
    
    long numberOfPaths(int m, int n) {
        // Code Here
        m--;
        n--;
        long answer = 1;
        for (int x=1; x <= m; x++) {
            answer = (answer * (n + x)) / x;
        }
        return answer;
    }
    
}