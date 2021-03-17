/*
Given a non-negative integer, num, repeatedly add all its digits until it has a single digit remaining and return it.

Ex: Given the following num...

num = 123, return 6 (1 + 2 + 3 = 6)
Ex: Given the following num...

num = 8353, return 1 (8 + 3 + 5 + 3 = 19 = 1 + 9 = 10 = 1 + 0 = 1).
*/


class Solution {
    public int addDigits(int num) {
        if (num == 0)
            return 0;
        if (num % 9 == 0)
            return 9;
        return num % 9;
    }
}