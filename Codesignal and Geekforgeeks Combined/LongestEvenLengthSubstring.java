// https://practice.geeksforgeeks.org/contest/interview-series-amdocs/problems/


//User function Template for Java
class Solution{
	public int substr(String s, int n) {
		//Write your code here
		// tracks the sum of the substring
		int [][] dp = new int [n][n];
		int maxEvenLength = 0;
		for (int i = 0; i < n; i++) {
		    // single letter
		    dp[i][i] = s.charAt(i) - '0';
		}
		for (int i = 2; i <= n; i++) {
		    for (int j = 0; j < n - i + 1; j++) {
		        int k = i + j - 1;
		        int sum = i / 2;
		        dp[j][k] = dp[j][k - sum] + dp[k - sum + 1][k];
		        // if optimal, update our answer
		        if (i % 2 == 0 && dp[j][k - sum] == dp[k - sum + 1][k] && i > maxEvenLength) {
		            maxEvenLength = i;
		        }
		    }
		}
		return maxEvenLength;
	}
}