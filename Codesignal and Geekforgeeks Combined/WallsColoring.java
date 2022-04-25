// https://practice.geeksforgeeks.org/contest/interview-series-47/problems/

//User function Template for Java

class Solution{
	int minCost(int [][] colors, int n){
        //Write your code here
        if (n == 1) {
            return Math.min(colors[0][0], Math.min(colors[0][1], colors[0][2]));
        }
        int [][] dp = new int [n][3];
        dp[0][0] = colors[0][0];
        dp[0][1] = colors[0][1];
        dp[0][2] = colors[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]) + colors[i][0];
            dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]) + colors[i][1];
            dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1]) + colors[i][2];
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}