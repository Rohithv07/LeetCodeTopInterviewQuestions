/*
You are given an integer array that represents the prices of items in a store. The ith price is given by prices[i]; however, the store is running a special discount. By buying the ith item, you receive a discount of prices[j] where prices[j] is less than or equal to prices[i] and j > i. If no such prices[j] exists, you pay for price for the ith item. Given these prices, return an array that represents the amount you’ll pay for each respective item considering the special discount.

Ex: Given the following prices…

prices = [3, 2, 2], return [1, 0, 2].
For prices[0] you pay 3 - 2 = 1 dollars.
For prices[1] you pay 2 - 2 = 0 dollars.
For prices[2] you pay 2 dollars.
*/

class Solution {
    public int[] finalPrices(int[] prices) {
        if (prices == null || prices.length == 0)
            return new int []{};
        int length = prices.length;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                prices[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}
