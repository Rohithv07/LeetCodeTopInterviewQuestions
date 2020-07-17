Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4

Solution (2 solutions) :
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        '''

        Solution with extra memory
         dict = {}
         for element in nums:
            if element in dict:
                dict[element] = False
            else:
                dict[element] = True
                
        for keys, value in dict.items():
            if value == True:
                return keys
            
        return 0


        '''
        
        # Without using extra memory
        
        count = collections.Counter(nums)
        
        for item, count in count.items():
            if count == 1:
                return item
