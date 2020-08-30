Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.

class Solution {
    public int lengthOfLIS(int[] array) {
        int [] dp = new int [array.length];
        int max = 0;
        for (int i=0; i<array.length; i++)
            dp[i] = 1;
        for (int i=1; i<array.length; i++) {
            for (int j=0; j<i; j++) {
                if (array[i] > array[j] && dp[i] < dp[j]+1)
                    dp[i] = dp[j] + 1;
            }
        }
        for (int i=0; i<dp.length; i++) {
            if (max < dp[i])
                max = dp[i];
        }
        return max;
    }
}
