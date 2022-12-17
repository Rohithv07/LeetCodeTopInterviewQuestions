Given an integer N. Find maximum LCM (Least Common Multiple) that can be obtained from four numbers less than or equal to N.
Note: Duplicate numbers can be used.

Example 1:

Input:
N = 4
Output: 12
Explanation:
The four numbers can be [4,4,3,2] or
[4,4,4,3], etc. It can be shown that 12 is
the maximum LCM of four numbers that can
be obtained from numbers less than or equal 
to 4.
Example 2:

Input:
N = 5
Output: 60
Explanation:
The four numbers can be [5,5,4,3] or
[5,4,3,2], etc. 60 is the maximum that can
be obtained.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxGcd() which takes N as the input parameter and returns the maximum LCM that can be obtained from four numbers less than or equal to N.

Expected Time Complexity: O( Log2(max(N)) )
Expected Auxillary Space: O(1)

Constraints:
2 ≤ N ≤ 104



class Solution {
    long maxGcd(int n) {
        // code here
        int numberCount = 1;
        long maxSum = n;
        for (long i = n - 1; i >= 2; i--) {
            if (findGCD(maxSum, i) == 1) {
                maxSum *= i;
                numberCount++;
            }
            if (numberCount >= 4) {
                break;
            }
        }
        return maxSum;
    }
    
    long findGCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}