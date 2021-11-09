
Suppose you have N eggs and you want to determine from which floor in a K-floor building you can drop an egg such that it doesn't break. You have to determine the minimum number of attempts you need in order find the critical floor in the worst case while using the best strategy.There are few rules given below. 

An egg that survives a fall can be used again.
A broken egg must be discarded.
The effect of a fall is the same for all eggs.
If the egg doesn't break at a certain floor, it will not break at any floor below.
If the eggs breaks at a certain floor, it will break at any floor above.
For more description on this problem see wiki page

Example 1:

Input:
N = 2, K = 10
Output: 4
Example 2:

Input:
N = 3, K = 5
Output: 3
Your Task:
Complete the function eggDrop() which takes two positive integer N and K as input parameters and returns the minimum number of attempts you need in order to find the critical floor.

Expected Time Complexity : O(N*K)
Expected Auxiliary Space: O(N*K)

Constraints:
1<=N<=10
1<=K<=50


class EggDrop 
{
    static int eggDrop(int n, int k) 
	{
	    // Your code here
	    int [][] dp = new int [n+1][k+1];
	    int result;
	    for (int i=1; i<=n; i++) {
	        dp[i][0] = 0;
	        dp[i][1] = 1;
	    }
	    for (int j=1; j<=k; j++) {
	        dp[1][j] = j;
	    }
	    for (int i=2; i<=n; i++) {
	        for (int j=2; j<=k; j++) {
	            dp[i][j] = Integer.MAX_VALUE;
	            for (int floor=1; floor<=j; floor++) {
	                result = 1 + Math.max(dp[i-1][floor-1], dp[i][j-floor]);
	                dp[i][j] = Math.min(result, dp[i][j]);
	            }
	        }
	    }
	    return dp[n][k];
	}
}


// optimised

class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) 
	{
	    // Your code here
	    int [][] dp = new int [n + 1][k + 1];
	    int moves = 0;
	    while (dp[n][moves] < k) {
	        moves++;
	        for (int egg=1; egg<=n; egg++) {
	            dp[egg][moves] = dp[egg - 1][moves - 1] + dp[egg][moves - 1] + 1;
	        }
	    }
	    return moves;
	}
}
