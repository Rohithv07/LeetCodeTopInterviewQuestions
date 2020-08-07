Power of Four


Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true
Example 2:

Input: 5
Output: false


Solution1:

class Solution:
    def isPowerOfFour(self, num: int) -> bool:
        if num < 1:
            return False
        logarithmic_check = math.log(num, 4)
        return logarithmic_check == int(logarithmic_check)

Solution 2:(Using Binary)
class Solution:
    def isPowerOfFour(self, num: int) -> bool:
        if num < 0:
            return False
        
        binary = bin(num).replace('0b', '')
        counter_1 = binary.count("1")
        counter_0 = binary.count("0")
        
        if counter_1 == 1 and counter_0 % 2 == 0:
            return True
        
        return False
