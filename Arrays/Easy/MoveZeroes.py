Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

Solution:
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        current_zero = 0
        for elements in range(0, len(nums)):
            if nums[elements] != 0:
                nums[current_zero], nums[elements] = nums[elements], nums[current_zero]
                current_zero += 1
        
