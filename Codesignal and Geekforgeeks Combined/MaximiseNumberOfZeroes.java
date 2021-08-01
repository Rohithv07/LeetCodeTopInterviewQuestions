Given a binary array arr of size N and an integer M. Find the maximum number of consecutive 1's produced by flipping at most M 0's.
 

Example 1:

Input:
N = 3
arr[] = {1, 0, 1}
M = 1
Output:
3
Explanation:
Maximum subarray is of size 3
which can be made subarray of all 1 after
flipping two zeros to 1.
Example 2:

Input:
N = 11
arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
M = 2
Output:
8
Explanation:
Maximum subarray is of size 8
which can be made subarray of all 1 after
flipping two zeros to 1.
 

Your Task:
Complete the function findZeroes() which takes array arr and two integers n, m, as input parameters and returns an integer denoting the answer.
 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
 

Constraints:
1 <= N <= 107
0 <= M <= N
0 <= arri <= 1


class Solve {
    // m is maximum of number zeroes allowed to flip
    int findZeroes(int nums[], int n, int m) {
        // code here
        if (nums == null || nums.length == 0)
            return 0;
        int result = 0;
        int start = 0;
        int zeroCount = 0;
        for (int end = 0; end < n; end ++) {
            if (nums[end] == 0) {
                zeroCount += 1;
            }
            while (zeroCount > m) {
                if (nums[start] == 0) {
                    zeroCount -= 1;
                }
                start += 1;
            }
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}