Given an array arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the minimum sum and return its sum.

Example 1:

Input: 
arr[] = {3,-4, 2,-3,-1, 7,-5}
Output: -6
Explanation: sub-array which has smallest 
sum among all the sub-array is {-4,2,-3,-1} = -6
Example 2:

Input:
arr[] = {2, 6, 8, 1, 4}
Output: 1
Explanation: sub-array which has smallest
sum among all the sub-array is {1} = 1
Your Task:
You don't need to read input or print anything. The task is to complete the function smallestSubarraySum() which takes arr[] and N as input parameters and returns the sum of subarray with minimum sum.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 106
-107 ≤ A[i] ≤ 107



class Solution
{
    static int smallestSumSubarray(int a[], int size)
    {
        // your code here
        int minimumSum = Integer.MAX_VALUE;
        int prefixSum = 0;
        for (int num : a) {
            prefixSum += num;
            minimumSum = Math.min(minimumSum, prefixSum);
            if (prefixSum > 0) {
                prefixSum = 0;
            }
        }
        return minimumSum;
    }
}