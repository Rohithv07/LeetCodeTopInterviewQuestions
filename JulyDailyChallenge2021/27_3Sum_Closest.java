Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 

Constraints:

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        Arrays.sort(nums);
        int possibleResult = nums[0] + nums[1] + nums[length - 1];
        for (int i=0; i+2<length; i++) {
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if (currentSum > target) {
                    right --;
                }
                else if (currentSum == target) {
                    return target;
                }
                else {
                    left ++;
                }
                if (Math.abs(currentSum - target) < Math.abs(possibleResult - target)) {
                    possibleResult = currentSum;
                }
            }
        }
        return possibleResult;
    }
}