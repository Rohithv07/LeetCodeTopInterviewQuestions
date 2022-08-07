Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.

 

Example 1:

Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
Example 2:

Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
Example 3: 

Input: n = 5
Output: 68
 

Constraints:

1 <= n <= 2 * 10^4


class Solution {
    public int countVowelPermutation(int n) {
        if (n == 1) {
            return 5;
        }
        if (n == 2) {
            return 10;
        }
        long [][] dp = new long [n][5];
        long MOD = (long)(1e9 + 7);
        for (int i = 0; i < 5; i++) {
            dp[0][i] = 1;
        }
        // a -> e, i, u   - 0
        // e -> a, i      - 1
        // i -> o, e      - 2
        // o -> i         - 3
        // u -> i, o      - 4
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][3] + dp[i - 1][1]) % MOD;
            dp[i][3] = dp[i - 1][2] % MOD;
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
        }
        long countPermutation = 0;
        for (int i = 0; i < 5; i++) {
            countPermutation = (countPermutation + dp[n - 1][i]) % MOD;
        }
        return (int)(countPermutation);
    }
}