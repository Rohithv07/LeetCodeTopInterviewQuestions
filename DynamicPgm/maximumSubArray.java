Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

Solution:

class Solution {
    public int maxSubArray(int[] nums) {
        int maximumSum = nums[0];
        int currentSum = maximumSum;
        for (int i=1; i<nums.length; i++){
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maximumSum = Math.max(currentSum, maximumSum);
        }
        return maximumSum;
    }
}

/* Here we initialise a maximum sum as the first element of the arrays

 * Then we have current_sum initially the maximum sum
 
 * Now we loop through the array from the index of 1.
 
 * We update our current_sum taking maximum from  sum of number at ith index + current sum and  comparing with the initial current sum
 
 * Next we update our maximum_sum comparing with the current sum
 
 * Now just return the maximum sum and we get our answer.
*/
