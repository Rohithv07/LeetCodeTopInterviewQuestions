Given two strings. The task is to find the length of the longest common substring.


Example 1:

Input: S1 = "ABCDGH", S2 = "ACDGHR"
Output: 4
Explanation: The longest common substring
is "CDGH" which has length 4.
Example 2:

Input: S1 = "ABC", S2 "ACB"
Output: 1
Explanation: The longest common substrings
are "A", "B", "C" all having length 1.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestCommonSubstr() which takes the string S1, string S2 and their length n and m as inputs and returns the length of the longest common substring in S1 and S2.


Expected Time Complexity: O(n*m).
Expected Auxiliary Space: O(n*m).






class Solution{
    int longestCommonSubstr(String s1, String s2, int n, int m){
        // code here
        int [][] dp = new int [n + 1][m + 1];
        int result = 0;
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=m; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        return result;
    }
}
/*
ABCDGH    char equal dp[i][j] = dp[i - 1][j - 1] + 1
ACDGHR      else dp[i][j] =0    max from the dp array is the answer
     ''  A    C    D    G   H    R 
''   0   0    0    0   0    0    0
 
 A   0   1    0    0    0   0    0
 
 B   0   0    0    0    0   0    0
 
 C   0   0    1    0    0   0    1  
 
 D   0   0    0    2    0   0    0
 
 G   0   0    0    0    3   0    0
 
 H   0   0    0    0    0    4   0
 
*/
