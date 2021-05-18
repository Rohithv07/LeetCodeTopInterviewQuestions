/*
Given an integer, num, return whether or not it is a perfect number.
Note: A perfect number is a positive number that is equal to the sum of its positive divisors excluding itself.

Ex: Given the following num…

num = 6, return true (1 + 2 + 3 = 6).
Ex: Given the following num…

num = 7, return false.

*/


class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1 || num == 2)
            return false;
        int sum = 0;
        for (int i=2; i*i <= num; i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        sum += 1;
        return sum == num ;
    }
}
