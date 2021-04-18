/*
Given an array Arr of size N and a positive integer K, find the sub-array of length K with the maximum average.


Example 1:

Input:
K = 4, N = 6
Arr[] = {1, 12, -5, -6, 50, 3}
Output: 12 -5 -6 50
Explanation: Maximum average is 
(12 - 5 - 6 + 50)/4 = 51/4.

Example 2:

Input:
K = 3, N = 7
Arr[] = {3, -435, 335, 10, -50, 100, 20}
Output: 335 10 -50
Explanation: Maximum average is 
(335 + 10 - 50)/3 = 295/3.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findMaxAverage() which takes the array of integers arr, its size n and integer k as input parameters and returns an integer denoting the starting index of the subarray.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints
1 <= N <= 105
0 <= |Arr[i]| <= 103
*/


class Solution {
    int findMaxAverage(int[] arr, int n, int k) {
        // code here
        if (k > n)
            return -1;
        int cumulativeSum = 0;
        for (int i=0; i<k; i++) {
            cumulativeSum += arr[i];
        }
        int maxSum = cumulativeSum;
        int maxIndex = k - 1;
        for (int i=k; i<n; i++) {
            cumulativeSum = cumulativeSum + arr[i] - arr[i - k];
            if (cumulativeSum > maxSum) {
                maxSum = cumulativeSum;
                maxIndex = i;
            }
        }
        return maxIndex - k + 1;
    }
}

