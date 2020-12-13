Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167


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
