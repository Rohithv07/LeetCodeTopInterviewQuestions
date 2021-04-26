/*
Given an integer value, N, return the Nth Fibonacci number.
Note: Fibonacci numbers are a number sequence where Fibonacci(N) = Fibonacci(N - 1) + Fibonacci(N - 2). The first two Fibonacci numbers are zero and one.

Ex: Given the following N…

N = 2, return 1 (one is the second number in the Fibonnaci sequence).
Ex: Given the following N…

N = 3, return 2 (Fibonnaci(3) = Fibonacci(2) + Fibonacci(1) = 1 + 1 = 2).
*/


class Solution {
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int [] dp = new int [n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
