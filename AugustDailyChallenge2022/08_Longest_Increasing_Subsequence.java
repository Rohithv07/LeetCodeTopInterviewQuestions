Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?




class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int maxLength = 0;
        int [] dp = new int [length + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        for (int num : dp) {
            maxLength = Math.max(maxLength, num);
        }
        return maxLength;
    }
}




class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int length = nums.length;
        int [] dp = new int [length];
        int maxResult = 0;
        for (int num : nums) {
            int left = 0;
            int right = maxResult;
            while (left < right) {
                int middle = left + (right - left) / 2;
                if (dp[middle] < num) {
                    left = middle + 1;
                }
                else {
                    right = middle;
                }
            }
            dp[left] = num;
            if (left == maxResult) {
                maxResult++;
            }
        }
        for (int num : dp) {
            System.out.println(num);
        }
        return maxResult;
    }
}
/*
0 1 0 3 2 3

0 1 0 3 2 3
we start with 0
now next number is 1, 0 < 1 so 0 1 
next number is 0, but this does not help us in building lis if we append like 0 1 0,
so we just binary search and find the smallest number >= x which is 0 here -> 0 1
next number is 3, this will help in lis contribution so 0 1 3
next number is 2, but when we append it, this will not be lis, so we find the smallest number >= x, which is 3 in this case -> 0 1 2
last number is 3, this will help in lis contribution so 0 1 2 3
this will be our last subsequence and its length is 4.

*/