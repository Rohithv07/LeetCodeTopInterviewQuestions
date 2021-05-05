/*
Given a non-negative integer, num, return the number of operations it takes to reduce it to zero. If num is even, divide it by two. If num is odd, subtract one from it. Continue this process until num is zero.

Ex: Given the following num…

num = 5, return 4 (subtract 1, divide by 2, divide by 2, subtract 1).
Ex: Given the following num…

num = 16, return 5.
*/


class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                count += 1;
                num /= 2;
            }
            else {
                count += 1;
                num -= 1;
            }
        }
        return count;
    }
}
