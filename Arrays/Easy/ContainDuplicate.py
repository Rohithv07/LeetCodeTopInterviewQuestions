Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true

Solution (2 solutions):
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
   #     if len(nums) == 0:
   #         return False
   #     dict = {}
   #     for elements in nums:
   #         if elements in dict.keys():
   #             return True
   #         else:
   #             dict[elements] = True
        
   #     return False
    
        return len(set(nums)) != len(nums)
            
