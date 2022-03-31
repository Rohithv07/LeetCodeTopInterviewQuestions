Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.

Write an algorithm to minimize the largest sum among these m subarrays.

 

Example 1:

Input: nums = [7,2,5,10,8], m = 2
Output: 18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], m = 2
Output: 9
Example 3:

Input: nums = [1,4,4], m = 3
Output: 4
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= m <= min(50, nums.length)





class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = findMax(nums);
        int right = findTotal(nums);
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (isLargestSum(nums, middle, m)) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return left;
    }
    
    public boolean isLargestSum(int [] nums, int limit, int m) {
        int total = 0;
        int split = 1;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (total > limit) {
                total = nums[i];
                split++;
                if (split > m) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int findMax(int [] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
    
    public int findTotal(int [] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return total;
    }
    
}