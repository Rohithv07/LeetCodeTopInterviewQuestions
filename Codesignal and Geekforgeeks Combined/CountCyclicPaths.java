Given a triangular pyramid with its vertices marked as O, A, B and C and a number N, the task is to find the number of ways such that a person starting from the origin O initially, reaches back to the origin in N steps. In a single step, a person can go to any of its adjacent vertices.

Lightbox


Example 1:

Input:
N = 1
Output: 0
Explanation: The minimum length of
a cyclic path is 2.
Example 2:

Input:
N = 2
Output: 3
Explanation: The three paths are :
O-A-O, O-B-O, O-C-O

Your Task:  
You don't need to read input or print anything. Your task is to complete the function countPaths() which takes an integer N as input parameter and returns the number of possible paths. Since the answer may be big, return it modulo (10^9+7). 


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 106


class Solution{
	public static int countPaths(int n){
		//code here
		if (n == 1)
		    return 0;
		if (n == 0)
		    return 1;
		long [][] dp = new long [4][n + 1];
		int mod = (int)1e9 + 7;
		dp[0][0] = 1;
		dp[1][0] = 0;
		dp[2][0] = 0;
		dp[3][0] = 0;
		for (int i=1; i<=n; i++) {
		    long o = ((dp[1][i - 1] % mod) + (dp[2][i - 1] % mod) + (dp[3][i - 1] % mod)) % mod;
		    long a = ((dp[0][i - 1] % mod) + (dp[2][i - 1] % mod) + (dp[3][i - 1] % mod)) % mod;
		    long b = ((dp[0][i - 1] % mod) + (dp[1][i - 1] % mod) + (dp[3][i - 1] % mod)) % mod;
		    long c = ((dp[0][i - 1] % mod) + (dp[1][i - 1] % mod) + (dp[2][i - 1] % mod)) % mod;
		    dp[0][i] = o % mod;
		    dp[1][i] = a % mod;
		    dp[2][i] = b % mod;
		    dp[3][i] = c % mod;
		}
		return (int)(dp[0][n] % mod);
	}
}



/*
dp[origin][i] = 3*dp[lower][i-1]   (We can move to the origin from 3 lower vertices)

dp[lower][i] = 2*dp[lower][i-1] + dp[origin][i-1] 
(We can move to a lower vertice from either one of two remaining lower
vertices or the origin)

*/


class Solution{
	public static int countPaths(int n){
		//code here
		if (n == 1) {
		    return 0;
		}
		
		long low = 1l;
		long  high = 0l;
		long tlow = 1l;
		long thigh = 0l;
		final long MOD = (long)(1e9 + 7);
		for (int i = 2; i <= n; i++) {
		    high = (3 * tlow) % MOD;
		    low = (((2 * tlow) % MOD) + thigh) % MOD;
		    tlow = low;
		    thigh = high;
		}
		return (int)high;
	}
}
// 0, 3, 6, 21