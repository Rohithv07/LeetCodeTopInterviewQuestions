/*
Given positive an integer num, return whether or not it is a perfect square.

Ex: Given the following num...

num = 9, return true.
Ex: Given the following num...

num = 18, return false.
*/


class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1)
            return true;
        int left = 1;
        int right = num / 2;
        while (left <= right) {
            long middle = left + (right - left) / 2;
            if (middle * middle == num)
                return true;
            if (middle * middle > num) {
                right = (int) middle - 1;
            }
            else {
                left = (int) middle + 1;
            }
        }
        return false;
    }
}