Given two strings S and T, find length of the shortest subsequence in S which is not a subsequence in T. If no such subsequence is possible, return -1. A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. A string of length n has 2^n different possible subsequences.

 

Example 1:

Input:
S = "babab"
T = "babba"
Output:
3
Explanation:
There are no subsequences of S with
length less than 3 which is not a
subsequence of T. "aab" is an example of
a subsequence of length 3 which isn't a
subsequence of T.
Example 2:

Input:
S = "babhi"
T = "babij"
Output:
1
Explanation:
"h" is a subsequence of S that is
not a subsequence of T.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function shortestUnSub() which takes two Strings S, and T as input and returns the shortest Uncommon Subsequence.

 

Expected Time Complexity: O(|S|2*|T|)
Expected Auxiliary Space: O(|S|*|T|)

 

Constraints:
1 <= |S|, |T| <= 500


//User function Template for Java

class Solution {
    static int shortestUnSub(String s, String t) {
        // code here
        int n = s.length();
        int m = t.length();
        final int MAX = 600;
        int [][] dp = new int [n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = MAX;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int k;
                for (k = j - 1; k >= 0; k--) {
                    if (t.charAt(k) == s.charAt(i - 1)) {
                        break;
                    }
                }
                if (k < 0) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][k] + 1);
                }
            }
        }
        if (dp[n][m] >= MAX) {
            return -1;
        }
        return dp[n][m];
    }
}