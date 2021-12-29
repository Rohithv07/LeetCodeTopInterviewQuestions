Given a value V and array coins[] of size M, the task is to make the change for V cents, given that you have an infinite supply of each of coins{coins1, coins2, ..., coinsm} valued coins. Find the minimum number of coins to make the change. If not possible to make change then return -1.


Example 1:

Input: V = 30, M = 3, coins[] = {25, 10, 5}
Output: 2
Explanation: Use one 25 cent coin
and one 5 cent coin
Example 2:
Input: V = 11, M = 4,coins[] = {9, 6, 5, 1} 
Output: 2 
Explanation: Use one 6 cent coin
and one 5 cent coin

Your Task:  
You don't need to read input or print anything. Complete the function minCoins() which takes V, M and array coins as input parameters and returns the answer.

Expected Time Complexity: O(V*M)
Expected Auxiliary Space: O(V)

Constraints:
1 ≤ V*M ≤ 106
All array elements are distinct


// 2d dp solution

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0)
            return -1;
        int length = coins.length;
        int [][] dp = new int [length + 1][amount + 1];
        for (int i=0; i<=length; i++) {
            for (int j=0; j<=amount; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                }
                else if (i == 0) {
                    dp[i][j] = amount + 2;
                }
                else if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                else  {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        return dp[length][amount] > amount ? -1 : dp[length][amount];
    }
}


// optimised 1d solution

class Solution{

	public int minCoins(int coins[], int m, int v) 
	{ 
	    // Your code goes here
	    if (coins == null || m == 0 || v < 0) {
	        return -1;
	    }
	    int [] dp = new int [v + 1];
	    Arrays.fill(dp, v + 1);
	    dp[0] = 0;
	    for (int i=1; i<=v; i++) {
	        for (int j=0; j<m; j++) {
	            if (coins[j] <= i) {
	                dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
	            }
	        }
	    }
	    return dp[v] > v ? -1 : dp[v];
	} 
}