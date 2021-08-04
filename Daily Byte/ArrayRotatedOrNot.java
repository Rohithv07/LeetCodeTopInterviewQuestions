/*
Given an integer array, nums, return whether or not the array was originally sorted in non-decreasing order and then rotated some number of positions.

Ex: Given the following nums…

nums = [4, 5, 1, 2, 3], return true (values 4 and 5 were rotated to the beginning of the array).
Ex: Given the following nums…

nums = [4, 5, 1, 2, 3, 6], return false.
*/

class Solution {
    public boolean check(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int irregularity = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length])
                irregularity += 1;
        }
        return irregularity <= 1;
    }
}