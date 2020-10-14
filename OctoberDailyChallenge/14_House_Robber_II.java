You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [0]
Output: 0
 


// here if we start from the first house, then since its circular, then we cant select the second one
// here if we start from the second house, then we can select the last one except the first house.
// so we can have 2 arrays separate from storing the valuse if we start from the first house or if we start from the second house.
// then do the same work as that of house robber 1 on passing these two arrays.


class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int length = nums.length;
        int [] dp = new int [length];
        // stores the value from 0 to n-1 (excluding)
        int [] ifFirst = Arrays.copyOfRange(nums, 0, length-1);
        // stores the value from 1 to n(excluding)
        int [] ifSecond = Arrays.copyOfRange(nums, 1, length);
        return Math.max(houseRob(ifFirst), houseRob(ifSecond));
    }
    // function that we used for house robber 1
    public int houseRob(int [] array) {
        int length = array.length;
        int [] dp = new int [length+1];
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);
        for (int i=2; i<length; i++)
            dp[i] = Math.max(dp[i-1], dp[i-2]+array[i]);
        return dp[length-1];
    }
}
