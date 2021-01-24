"""
Given an array digits that represents a non-negative integer, add one to the number and return the result as an array.

Ex: Given the following digits...

digits = [1, 2], return [1, 3].
Ex: Given the following digits...

digits = [9, 9], return [1, 0, 0].
"""


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        
        length = len(digits) - 1
        number = 0
        for element in digits:
            number += (element * 10 ** length)
            length -= 1
        
        number += 1
        number = str(number)
        return list(number)