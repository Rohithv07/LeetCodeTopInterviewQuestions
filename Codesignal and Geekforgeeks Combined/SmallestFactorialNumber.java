Given a number n. The task is to find the smallest number whose factorial contains at least n trailing zeroes.

Example 1:

Input:
n = 1
Output: 5
Explanation : 5! = 120 which has at
least 1 trailing 0.
Example 2:

Input:
n = 6
Output: 25
Explanation : 25! has at least
6 trailing 0.

User Task:
Complete the function findNum() which takes an integer N as input parameters, and returns the answer.

Expected Time Complexity: O(log2 N * log5 N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= n <= 104


//User function Template for Java

class Solution
{
    int findNum(int n)
    {
        // Complete this function
        int low = 1;
        int high = n * 5;
        int result = -1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (zeroCount(middle) >= n) {
                result = middle;
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return result;
    }
    
    int zeroCount(int n) {
        int count = 0;
        for (int i = 5; i <= n; i = i * 5) {
            count += n / i;
        }
        return count;
    }
}