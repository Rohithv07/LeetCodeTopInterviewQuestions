/*
Given a sorted integer array, nums, remove duplicates from the array in-place such that each element only appears once. Once you’ve removed all the duplicates, return the length of the new array.
Note: The values you leave beyond the new length of the array does not matter.

Ex: Given the following nums…

nums = [1, 2, 2, 4, 4, 6, 8, 8], return 5.
Ex: Given the following nums…

nums = [1, 2, 3, 3], return 3.
*/



class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int index = 0;
        for (int i=1; i<length; i++) {
            if (nums[index] != nums[i]) {
                index += 1;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }
}