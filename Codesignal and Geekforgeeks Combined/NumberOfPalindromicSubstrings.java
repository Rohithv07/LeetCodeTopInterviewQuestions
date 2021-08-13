Given two integers N and K, the task is to find the count of palindromic strings of length lesser than or equal to N, with first K characters of lowercase English language, such that each character in a string doesn’t appear more than twice.

Note: Anwer can be very large, so, output answer modulo 109+7

Example 1:

Input: N = 3, K = 2
Output: 6
Explanation: The possible strings are:
"a", "b", "aa", "bb", "aba", "bab".
Example 2:

Input: N = 4, K = 3
Output: 18
Explanation: The possible strings are: 
"a", "b", "c", "aa", "bb", "cc", "aba",
"aca", "bab", "bcb", "cac", "cbc", 
"abba", "acca", "baab", "bccb", "caac", 
"cbbc". 
Your task:
You do not need to read any input or print anything. The task is to complete the function palindromicStrings(), which takes two integers as input and returns the count.

Expected Time Complexity: O(K2)
Expected Auxiliary Space: O(K2)

Constraints:
1 ≤ K ≤ 26
1 ≤ N ≤ 52
N ≤ 2*K


/*
If n=1, no. of ways=k.
if n=2, no. of ways=k,
if n=3, no.of ways=k*(k-1)
if n=4, no. of ways=k*(k-1)
if n=5, no. of ways=k*(k-1)*(k-2)
if n=6, no. of ways=k*(k-1)*(k-2)
*/

class Solution {
    int palindromicStrings(int n, int k) {
        // code here
        if (n == 0 || k == 0)
            return 0;
        long mod = (long) 1e9 + 7;
        long [] dp = new long [n + 1];
        long total = 0;
        dp[0] = 0;
        dp[1] = k;
        if (n <= 1)
            return (int)dp[n];
        dp[2] = k;
        for (int i=3; i<=n; i++) {
            int value = (i - 1) / 2;
            dp[i] = (dp[i - 2] * (k - value)) % mod;
        }
        for (int i=1; i<=n; i++) {
            total = (total + dp[i]) % mod;
        }
        return (int)(total % mod);
    }
}