class Solution {

    public int getSum(int x, int y, int z) {
        // Your code goes here
        int mod = (int)1e9 + 7;
        int n = 101;
        long [][][] dp = new long [n][n][n];
        long [][][] num = new long [n][n][n];
        long answer = 0;
        num[0][0][0] = 1;
        for (int i=0; i<=x; i++) {
            for (int j=0; j<=y; j++) {
                for (int k=0; k<=z; k++) {
                    if (i > 0) {
                        dp[i][j][k] += (dp[i - 1][j][k] * 10 + 4 * num[i - 1][j][k]) % mod;
                        num[i][j][k] += num[i - 1][j][k] % mod;
                    }
                    if (j > 0) {
                        dp[i][j][k] += (dp[i][j-1][k] * 10 + 5 * num[i][j - 1][k]) % mod;
                        num[i][j][k] += num[i][j - 1][k] % mod;
                    }
                    if (k > 0) {
                        dp[i][j][k] += (dp[i][j][k-1] * 10 + 6 * num[i][j][k-1]) % mod;
                        num[i][j][k] += num[i][j][k - 1] % mod;
                    }
                    answer += dp[i][j][k] % mod;
                    answer %= mod;
                }
            }
        }
        return (int)answer;
    }
}