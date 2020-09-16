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
Follow up:

Your algorithm should run in O(n) time and uses constant extra space.


Solution:

class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 1
        if nums:
            maximum = max(nums)
        else:
            maximum = 0
        if maximum < 0:
            maximum = 1
        for i in range(1, maximum+2):
            if i not in nums:
                return i
