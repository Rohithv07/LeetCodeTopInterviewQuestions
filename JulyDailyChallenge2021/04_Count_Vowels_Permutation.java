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
        if (n == 1)
            return 5;
        if (n == 2)
            return 10;
        long [][] dp = new long [n + 1][5];
        int mod = (int) 1e9 + 7;
        // single letter 
        for (int i=0; i<5; i++) {
            dp[1][i] = 1;
        }
        /*
        a - 0th
        e - 1st
        i - 2nd
        o - 3rd
        u - 4th
        */
        for (int i=1; i<n; i++) {
            // a is followed in e, i, u
            dp[i + 1][0] = (dp[i][1] + dp[i][2] + dp[i][4]) % mod;
            // e is followed in a, i
            dp[i + 1][1] = (dp[i][0] + dp[i][2]) % mod;
            // i is followed in e, o
            dp[i + 1][2] = (dp[i][1] + dp[i][3]) % mod;
            // o is followed in i only
            dp[i + 1][3] = (dp[i][2]) % mod;
            // u is followed in i, o
            dp[i + 1][4] = (dp[i][2] + dp[i][3]) % mod;
        }
        long answer = 0;
        for (int i=0; i<5; i++) {
            answer = (answer + dp[n][i]) % mod;
        }
        return (int) answer;
    }
}


// 0 based index, so we dont want to take n + 1


class Solution {
    public int countVowelPermutation(int n) {
        if (n == 1)
            return 5;
        if (n == 2)
            return 10;
        int mod = (int)1e9 + 7;
        long [][] dp = new long [n][5];
        for (int i=0; i<5; i++) {
            dp[0][i] = 1;
        }
        /*
        a - 0 -> e i u
        e - 1 -> a i
        i - 2 -> e o
        o - 3 -> i
        u - 4 -> o i
        */
        for (int i=1; i<n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % mod;
            dp[i][3] = (dp[i - 1][2]) % mod;
            dp[i][4] = (dp[i - 1][3] + dp[i - 1][2]) % mod;
        }
        long answer = 0;
        for (int i=0; i<5; i++) {
            answer = (answer + dp[n - 1][i]) % mod;
        }
        return (int)answer;
    }
}
