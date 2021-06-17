We are given an array nums of positive integers, and two positive integers left and right (left <= right).

Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least left and at most right.

Example:
Input: 
nums = [2, 1, 4, 3]
left = 2
right = 3
Output: 3
Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
Note:

left, right, and nums[i] will be an integer in the range [0, 109].
The length of nums will be in the range of [1, 50000].

class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        if (nums == null || nums.length == 0)
            return 0;
        int j = 0;
        int subarray = 0;
        int count = 0;
        int length = nums.length;
        for (int i=0; i<length; i++) {
            int number = nums[i];
            if (number >= left && number <= right) {
                subarray += i - j + 1;
                count = i - j + 1;
            }
            else if (number < left) {
                subarray += count;
            }
            else {
                count = 0;
                j = i + 1;
            }
        }
        return subarray;
    }
}

/*
2  3  7  10
10 8  7  3

*/
