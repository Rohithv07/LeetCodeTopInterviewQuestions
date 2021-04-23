Given two strings S1 and S2, find the number of times the second string occurs in the first string, whether continuous or discontinuous.


Example 1:

Input: 
S1 = geeksforgeeks
S2 = gks
Output: 4
Explaination: For the first 'g' there 
are 3 ways and for the second 'g' there 
is one way. Total 4 ways.

Your Task:
You don't need to read input or print anything. Your task is to complete the function countWays() which takes the string S1 and S2 as input parameters and returns the number of ways.


Expected Time Complexity: O(n*m)        [n and m are length of the strings]
Expected Auxiliary Space: O(n*m)


Constraints:
1 ≤ n, m ≤ 500


class Solution {
    int countWays(String a, String b) { 
        // code here 
        int length1 = a.length();
        int length2 = b.length();
        int [][] dp = new int [length1 + 1][length2 + 1];
        for (int i=0; i<=length1; i++) {
            dp[i][0] = 1;
        }
        for (int i=1; i<=length1; i++) {
            for (int j=1; j<=length2; j++) {
                if (a.charAt(i -1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[length1][length2];
    }
}
