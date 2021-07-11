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