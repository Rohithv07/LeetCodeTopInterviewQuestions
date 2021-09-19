Given two strings s and t, return the number of distinct subsequences of s which equals t.

A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).

It is guaranteed the answer fits on a 32-bit signed integer.

 

Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from S.
rabbbit
rabbbit
rabbbit
Example 2:

Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from S.
babgbag
babgbag
babgbag
babgbag
babgbag
 

Constraints:

1 <= s.length, t.length <= 1000
s and t consist of English letters.


class Solution {
    public int numDistinct(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        int [][] dp = new int [length1 + 1][length2 + 1];
        // if t is null, then there is 1 possibilty of converting s to null by not selecting any char

        // please consider where we are taking s and t ie in row or col
        // if s is taken as col then the first row must be filled with 1. Then if two char become equal, dp[i][j] = dp[i - 1][j - 1] + dp[ i -1][j];
        // if s is taken row then the first col must be filled with 1. Then if two char become equal, dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
        for (int i=0; i<=length1; i++) {
            dp[i][0] = 1;
        }
        for (int i=1; i<=length1; i++) {
            for (int j=1; j<=length2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
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