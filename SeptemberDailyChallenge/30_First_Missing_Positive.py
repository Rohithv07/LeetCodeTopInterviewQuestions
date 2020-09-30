Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1

Solution:

class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 1
        if nums:
            maximumValue = max(nums)
        else:
            maximumValue = 1
        if maximumValue < 1:
            maximumValue = 1
        for i in range(1, maximumValue+2):
            if i not in nums:
                return i
