Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

 

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
 

Follow up: Can you solve it in O(n) time complexity?


class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 0;
        }
        int fromBeginning = -1;
        int fromEnd = -1;
        int max = nums[0];
        int min = nums[length - 1];
        for (int i = 1; i < length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[length - i - 1]);
            if (nums[i] < max) {
                fromEnd = i;
            }
            if (nums[length - i - 1] > min) {
                fromBeginning = length - i - 1;
            }
        }
        return fromEnd - fromBeginning + 1 == 1 ? 0 : fromEnd - fromBeginning + 1;
    }
}