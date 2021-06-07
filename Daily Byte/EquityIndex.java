/*
Given an array of integers, nums, return the “equality index” if it exists and negative one otherwise.
Note: The equality index of the array is the index where the sum of all elements to the left of the index is equal to the sum of all elements to the right of the index.

Ex: Given the following nums…

nums = [1, 2, 5, 2, 1], return 2 (1 + 2 = 2 + 1)
Ex: Given the following nums…

nums = [3, 1, 9, 2], return -1;
*/


class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0 || nums == null)
            return -1;
        int length = nums.length;
        int leftSum = 0;
        int rightSum = 0; // total sum
        for (int number : nums) {
            rightSum += number;
        }
        for (int i=0; i<length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
    
}