Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.






Solution 1:
class Solution {
    public int maxProduct(int[] nums) {
        int product = 1;
        int maximumProduct = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            product *= nums[i];
            maximumProduct = Math.max(maximumProduct, product);
            if (product == 0)
                product = 1;
        }
        product = 1;
        for (int i=nums.length-1; i>=0; i--) {
            product *= nums[i];
            maximumProduct = Math.max(maximumProduct, product);
            if (product == 0)
                product = 1;
        }
        return maximumProduct;
    }
}




Solution 2:
class Solution {
    public int maxProduct(int[] nums) {
        int currentMaximum = nums[0];
        int maximum = nums[0];
        int currentMinimum = nums[0];
        for (int i=1; i<nums.length; i++) {
            int nextMaximum = nums[i] * currentMaximum;
            int nextMinimum = nums[i] * currentMinimum;
            currentMaximum = Math.max(nums[i], Math.max(nextMaximum, nextMinimum));
            currentMinimum = Math.min(nums[i], Math.min(nextMaximum, nextMinimum));
            maximum = Math.max(maximum, currentMaximum);
        }
        return maximum;
    }
}





