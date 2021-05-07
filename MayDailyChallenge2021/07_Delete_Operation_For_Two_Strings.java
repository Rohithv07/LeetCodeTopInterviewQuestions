Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

 

Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4
 

Constraints:

1 <= word1.length, word2.length <= 500
word1 and word2 consist of only lowercase English letters.





// find the lcs length and subtract the lcs length from the lengths of word1 and word2

class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2))
            return 0;
        int length1 = word1.length();
        int length2 = word2.length();
        int [][] dp = new int [length1 + 1][length2 + 1];
        for (int i=1; i<=length1; i++) {
            for (int j=1; j<=length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j - 1]);
            }
        }
        int longestCommon = dp[length1][length2];
        return length1 - longestCommon + length2 - longestCommon;
    }
}
