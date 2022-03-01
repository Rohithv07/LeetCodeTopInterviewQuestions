Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

 

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 

Constraints:

0 <= n <= 105
 

Follow up:

It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?



class Solution {
    public int[] countBits(int n) {
        if (n == 0) {
            return new int []{0};
        }
        if (n == 1) {
            return new int []{0, 1};
        }
        if (n == 2) {
            return new int []{0, 1, 1};
        }
        int [] result = new int [n + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 1;
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                result[i] += result[i / 2];
            }
            else {
                result[i] += 1 + result[i / 2];
            }
        }
        return result;
    }
}