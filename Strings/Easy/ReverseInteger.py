Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Solution:

class Solution:
    def reverse(self, x: int) -> int:
        string = str(x)
        if string[0] == '-':
            res = 0 - int(string[1:][::-1])
        else:
            res = int(string[::-1])
            
        if -2 ** 31 <= res <= 2 ** 31 - 1:
            return res
        return 0
