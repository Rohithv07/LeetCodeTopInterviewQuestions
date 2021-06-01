/*
Given an array of positive integers, nums, return the largest sum we can create such that it is divisible by three.

Ex: Given the following nums…

nums = [3, 1, 5, 8, 2], return 18 (3 + 5 + 8 + 2).
Ex: Given the following nums…

nums = [2, 4, 9], return 15.
*/


class Solution {
    public int maxSumDivThree(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            if (nums[0] % 3 == 0)
                return nums[0];
            return 0;
        }
        int [] dp = new int [3];
        for (int number : nums) {
            int [] temp = Arrays.copyOf(dp, dp.length);
            for (int value : temp) {
                dp[(number + value) % 3] = Math.max(dp[(number + value) % 3], value + number);
            }
        }
        return dp[0];
    }
}
