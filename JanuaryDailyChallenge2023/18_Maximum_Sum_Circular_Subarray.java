Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

 

Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
Example 3:

Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.
 

Constraints:

n == nums.length
1 <= n <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104


class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int length = nums.length;
        if (length == 0 || nums == null) {
            return 0;
        }
        int total = 0;
        int runningMax = 0;
        int runningMin = 0;
        int currentMax = Integer.MIN_VALUE;
        int currentMin = Integer.MAX_VALUE;
        for (int num : nums) {
            total += num;
            runningMax += num;
            currentMax = Math.max(currentMax, runningMax);
            runningMax = runningMax < 0 ? 0 : runningMax;
            runningMin += num;
            currentMin = Math.min(currentMin, runningMin);
            runningMin = runningMin > 0 ? 0 : runningMin;
        }
        if (total == currentMin) {
            return currentMax;
        }
        return Math.max(currentMax, total - currentMin);
    }
}