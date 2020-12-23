Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.

 

Example 1:

Input: n = 12
Output: 21
Example 2:

Input: n = 21
Output: -1



class Solution:
    def nextGreaterElement(self, n):
        digits = list(str(n))
        length = len(digits)
        
        i, j = length-2, length-1
        while i >= 0 and digits[i+1] <= digits[i]:
            i -= 1
        
        if i == -1: return -1

        while digits[j] <= digits[i]:
            j -= 1
        
        digits[i], digits[j] = digits[j], digits[i]

        res = int(''.join(digits[:i+1] + digits[i+1:][::-1]))
        if res >= 2**31 or res == n:
            return -1
        return res
