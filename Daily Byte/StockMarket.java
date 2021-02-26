class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int minBuy = prices[0];
        int maxBuy = 0;
        for (int number : prices) {
            minBuy = Math.min(minBuy, number);
            maxBuy = Math.max(maxBuy, number - minBuy);
        }
        return maxBuy;
    }
}
