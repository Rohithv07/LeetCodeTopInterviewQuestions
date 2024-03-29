Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

 

Example 1:

Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:

Input: c = 3
Output: false
Example 3:

Input: c = 4
Output: true
Example 4:

Input: c = 2
Output: true
Example 5:

Input: c = 1
Output: true
 

Constraints:

0 <= c <= 231 - 1


class Solution {
    public boolean judgeSquareSum(int c) {
        if (c <= 2)
            return true;
        int low = 0;
        int high = (int)Math.sqrt(c);
        while (low <= high) {
            int square = low * low + high * high;
            if (square == c)
                return true;
            if (square > c) {
                high--;
            }
            else {
                low++;
            }
        }
        return false;
    }
}

/*
1 2 3
1*1 + 2*2
2 * 2 + 3 * 3


*/