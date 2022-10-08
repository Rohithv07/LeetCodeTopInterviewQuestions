Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

Constraints:

3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int length = nums.length;
        int possibleAnswer = nums[0] + nums[1] + nums[length - 1];
        for (int i = 0; i + 2 < length; i++) {
            int left = i + 1;
            int right = length - 1;
            int val1 = nums[i];
            while (left < right) {
                int val2 = nums[left];
                int val3 = nums[right];
                int currentSum = val1 + val2 + val3;
                if (currentSum == target) {
                    return currentSum;
                }
                if (currentSum < target) {
                    left++;
                }
                else if (currentSum > target) {
                    right--;
                }
                if (Math.abs(currentSum - target) < Math.abs(possibleAnswer - target)) {
                    possibleAnswer = currentSum;
                }
            }
        }
        return possibleAnswer;
    }
}