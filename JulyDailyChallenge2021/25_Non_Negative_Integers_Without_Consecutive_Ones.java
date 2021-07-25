Given a positive integer n, return the number of the integers in the range [0, n] whose binary representations do not contain consecutive ones.

 

Example 1:

Input: n = 5
Output: 5
Explanation:
Here are the non-negative integers <= 5 with their corresponding binary representations:
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule. 
Example 2:

Input: n = 1
Output: 2
Example 3:

Input: n = 2
Output: 3
 

Constraints:

1 <= n <= 109



/*
the number of length k string without consecutive 1 is Fibonacci sequence f(k);
For example, if k = 5, the range is 00000-11111. We can consider it as two ranges, which are 00000-01111 and 10000-10111. Any number >= 11000 is not allowed due to consecutive 1. The first case is actually f(4), and the second case is f(3), so f(5)= f(4)+f(3).

Scan the number from most significant digit, i.e. left to right, in binary format. If we find a '1' with k digits to the right, count increases by f(k) because we can put a '0' at this digit and any valid length k string behind; After that, we continue the loop to consider the remaining cases, i.e., we put a '1' at this digit. If consecutive 1s are found, we exit the loop and return the answer. By the end of the loop, we return count+1 to include the number n itself.
For example, if n is 10010110,
we find first '1' at 7 digits to the right, we add range 00000000-01111111, which is f(7);
second '1' at 4 digits to the right, add range 10000000-10001111, f(4);
third '1' at 2 digits to the right, add range 10010000-10010011, f(2);
fourth '1' at 1 digits to the right, add range 10010100-10010101, f(1);
Those ranges are continuous from 00000000 to 10010101. And any greater number <= n will have consecutive 1.
*/

class Solution {
    public int findIntegers(int n) {
        int [] dp = new int [32];
        dp[0] = 1;
        dp[1] = 2;
        // fibanocci
        for (int i=2; i<32; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int i = 31;
        int sum = 0;
        int previousBit = 0;
        // finding the lastbit 0 or 1 and updating previous bit
        while (i >= 0) {
            if ((n & (1 << i)) != 0) {
                sum += dp[i];
                if (previousBit == 1) {
                    return sum;
                }
                previousBit = 1;
            }
            else {
                previousBit = 0;
            }
            i--;
        }
        return sum + 1;
    }
}