You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 

Constraints:

0 <= k <= 100
0 <= prices.length <= 1000
0 <= prices[i] <= 1000


class Solution {
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if (prices == null || k == 0 || length == 0) {
            return 0;
        }
        int [][] dp = new int [k + 1][length];
        for (int i = 0; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 0; j < length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], maxDiff + prices[j]);
                    maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
                }
            }
        }
        return dp[k][length - 1];
    }
}