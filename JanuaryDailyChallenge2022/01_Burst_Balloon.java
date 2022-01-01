You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

 

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:

Input: nums = [1,5]
Output: 10
 

Constraints:

n == nums.length
1 <= n <= 500
0 <= nums[i] <= 100

class Solution {
    public int maxCoins(int[] nums) {
        int length = nums.length;
        // we build a new array with the leftmost ie nums[-1] = 1 and nums[length] = 1;
        int index = 1;
        int [] newNums = new int [length + 2];
        for (int number: nums)
            if (number > 0)
                newNums[index++] = number;
        newNums[0] = 1;
        newNums[index++] = 1;
        int [][] dp = new int [length+2][length+2];
        // lets start from the second ballon bursrinf
        for (int k=2; k<length+2; k++) {
            for (int left = 0; left < index - k; left ++) {
                int right = left + k;
                for (int i=left+1; i<right; i++) {
                    dp[left][right] = Math.max(dp[left][right], newNums[left] * newNums[i] * newNums[right]
                                              + dp[i][right] + dp[left][i]);
                }
            }
        }
        return dp[0][index-1];
    }
}