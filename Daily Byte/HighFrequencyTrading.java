You are given the list of prices of a particular stock. Each element in the array represents the price of the stock at a given second throughout the current day. Return the maximum profit you can make trading this stock.
Note: You may only ever buy and sell a single share of the stock, but you may make multiple transactions (i.e. buys and sells).
Ex: Given the following prices...

prices = [8, 3, 2, 4, 6, 4, 5], return 5.

// Best Time to Buy and Sell Stock II

class Solution {
    public int maxProfit(int[] prices) {
        int maxWithoutStock = 0;
        int maxWithStock = Integer.MIN_VALUE;
        for (int price : prices) {
            maxWithStock = Math.max(maxWithStock, maxWithoutStock - price);
            maxWithoutStock = Math.max(maxWithoutStock, maxWithStock + price);
        }
        return maxWithoutStock;
    }
}
