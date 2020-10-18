You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Notice that you may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 

Constraints:

0 <= k <= 109
0 <= prices.length <= 104
0 <= prices[i] <= 1000


class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        if 2 * k >= len(prices):
            return sum(max(0, prices[i] - prices[i-1]) for i in range(1, len(prices)))
        p = [0] * len(prices)
        for i in range(k):
            val = 0
            for i in range(1, len(p)):
                val = max(p[i], val + prices[i] - prices[i-1])
                p[i] = max(p[i-1], val)
        return p[-1];
