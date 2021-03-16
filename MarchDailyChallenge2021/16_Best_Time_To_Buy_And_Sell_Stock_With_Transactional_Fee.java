You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Example 2:

Input: prices = [1,3,7,5,10,3], fee = 3
Output: 6
 

Constraints:

1 < prices.length <= 5 * 104
0 < prices[i], fee < 5 * 104






class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = -prices[0];
        for (int i=1; i<prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}

/*
->Only 1 share of the stock can be bought or sold;
->A stock can be bought or sold for multiple times in one day, but it has to be sold before being bought again;
->The service fee is only charged when stock is sold;
->Cash(i): the cash in hand, if you are not holding the stock at the end of day(i):
->You might be not holding the stock at the end of day(i-1), and do nothing in day(i): a = cash(i-1); or
->You might be holding the stock at the end of day(i-1), and sell it at the end of day(i):
b = hold(i-1) + prices[i] - fee;
->Choose the greatest one as the value of cash(i) to get the greater potential profit:
cash(i) = max(a, b) = max(cash(i-1), hold(i-1) + prices[i] - fee);
->Hold(i): the cash in hand, if you are holding the stock at the end of day(i):
->You might be holding the stock at the end of day(i-1), and do nothing in day(i): a = hold(i-1); or
->You might be not holding the stock at the end of day(i-1), and buy it at the end of day(i): b = cash(i-1) - prices[i]; or
->You might be holding the stock at the end of day(i-1), sell it on day(i), and buy it again at the end of day(i):
c = (hold(i-1) + prices[i] - fee) - prices[i];
->Choose the greatest one as the value of hold(i) to get the greater potential profit:
hold(i) = max(a,b,c)
->Because max(b, c) = max(cash(i-1), hold(i-1) + prices[i] - fee) - prices[i] = cash(i) - prices[i],
so hold(i) = max(hold(i-1), cash(i) - prices[i]);
->There is another way to calculate hold(i), which is more straight forward:
->You might be holding the stock at the end of day(i-1), and do nothing in day(i): a = hold(i-1); or
->You might be not holding the stock at the end of day(i-1), and buy it at the end of day(i): b = cash(i-1) - prices[i]; or
->You might be holding the stock at the end of day(i-1), sell it on day(i), and buy it again at the end of day(i):
c = (hold(i-1) + prices[i] - fee) - prices[i] = hold(i-1) - fee;
->Obviously, a > c, so max(a, c) = a, hold(i) = max(a, b, c) = max(a, b) = max(hold(i-1), cash(i-1) - prices[i])
->The target is to find the maximum profit at the end of day(N): cash(N);

