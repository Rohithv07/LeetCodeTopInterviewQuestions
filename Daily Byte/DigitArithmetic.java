/*
Given an integer, n, return the difference between the product and sum of its digits.

Ex: Given the following n…

n = 321, return 0 ((3 * 2 * 1) - (3 + 2 + 1).
Ex: Given the following n…

n = 56, return 19.
*/


class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int rem = n % 10;
            sum += rem;
            product *= rem;
            n /= 10;
        }
        return product - sum;
    }
}
