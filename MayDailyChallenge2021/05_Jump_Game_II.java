Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 105


class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        if (length <= 1)
            return 0;
        int [] interval = new int [] {0, 0};
        int minimumJumps = 0;
        while (true) {
            minimumJumps += 1;
            int canReach = -1;
            for (int i=interval[0]; i<=interval[1]; i++) {
                canReach = Math.max(canReach, i + nums[i]);
            }
                if (canReach >= length - 1) {
                    return minimumJumps;
                }
                interval[0] = interval[1] + 1;
                interval[1] = canReach;
        }
    }
}
