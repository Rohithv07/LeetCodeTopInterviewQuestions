Given a positive integer n, find the nth fibonacci number. Since the answer can be very large, return the answer modulo 1000000007.

Example 1:

Input: n = 2
Output: 1 
Explanation: 1 is the 2nd number
of fibonacci series.
Example 2:

Input: n = 5
Output: 5
Explanation: 5 is the 5th number
of fibonacci series.

Your Task:  
You dont need to read input or print anything. Complete the function nthFibonacci() which takes n as input parameter and returns nth fibonacci number.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1<= n <=1000


// 1. Normal recursion

//User function Template for Java
class Solution {
    
    final long MOD = (long)(1e9 + 7);
    // normal recursion will be exponential and surely will get TLE
    static long nthFibonacci(long n){
        // code here
        if (n <= 1) {
            return n;
        }
        return nthFibonacci(n - 1) + nthFibonacci(n - 2);
    }
} 


// 2. With Memoization - O(n) & O(n)

//User function Template for Java
class Solution {
    
    static final long MOD = (long)(1e9 + 7);
    static long nthFibonacci(long n){
        // code here
        if (n <= 1) {
            return n;
        }
        long [] fibonacciTracker = new long [(int)(n + 1)];
        Arrays.fill(fibonacciTracker, -1);
        fibonacciTracker[0] = 0l;
        fibonacciTracker[1] = 1l;
        return solveUsingMemo(n, fibonacciTracker);
    }
    
    static long solveUsingMemo(long n, long [] fibonacciTracker) {
        // base case
        if (n <= 1) {
            return n;
        }
        // have we solved previously
        if (fibonacciTracker[(int)n] != -1) {
            return fibonacciTracker[(int)n] % MOD;
        }
        return fibonacciTracker[(int)n] = ((solveUsingMemo(n - 1, fibonacciTracker)) + 
        (solveUsingMemo(n - 2, fibonacciTracker))) % MOD;
    }
} 

// 3. Tabulation - O(n) & O(n)

//User function Template for Java
class Solution {
    
    static final long MOD = (long)(1e9 + 7);
    static long nthFibonacci(long n){
        // code here
        if (n <= 1) {
            return n;
        }
        long [] fibonacciTracker = new long [(int)(n + 1)];
        Arrays.fill(fibonacciTracker, -1);
        fibonacciTracker[0] = 0l;
        fibonacciTracker[1] = 1l;
        for (long i = 2; i <= n; i++) {
            fibonacciTracker[(int)i] = (fibonacciTracker[(int)(i - 1)] + fibonacciTracker[(int)(i - 2)]) % MOD;
        }
        return fibonacciTracker[(int)n] % MOD;
    }
}


// 4. Space Optimization O(n) & O(1)

//User function Template for Java
class Solution {
    static long nthFibonacci(long n){
        // code here
        if (n <= 1) {
            return n;
        }
        final long MOD = (long)(1e9 + 7);
        long first = 0l;
        long second = 1l;
        int pointer = 2;
        long third = 0l;
        while (pointer <= n) {
            third = (first + second) % MOD;
            first = second % MOD;
            second = third % MOD;
            pointer++;
        }
        return third;
    }
}