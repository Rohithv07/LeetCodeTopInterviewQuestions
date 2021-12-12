Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100



// using 2 d array

class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int totalSum = findSum(nums);
        if (totalSum % 2 != 0) {
            return false;
        }
        int capacity = totalSum / 2;
        int length = nums.length;
        boolean [][] dp = new boolean [length + 1][capacity + 1];
        for (int i=0; i<=length; i++) {
            for (int j=0; j<=capacity; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }
                else if (j == 0) {
                    dp[i][j] = true;
                }
                else if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[length][capacity];
    }
    
    public int findSum(int [] nums) {
        int sum = 0;
        for (int number : nums) {
            sum += number;
        }
        return sum;
    }
}



// using 1 d array

class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int totalSum = findSum(nums);
        if (totalSum % 2 != 0) {
            return false;
        }
        int capacity = totalSum / 2;
        int length = nums.length;
        boolean [] dp = new boolean [capacity + 1];
        dp[0] = true;
        for (int number : nums) {
            for (int i=capacity; i>0; i--) {
                if (number <= i) {
                    dp[i] = dp[i] || dp[i - number];
                }
            }
        }
        return dp[capacity];
    }
    
    public int findSum(int [] nums) {
        int sum = 0;
        for (int number : nums) {
            sum += number;
        }
        return sum;
    }
}