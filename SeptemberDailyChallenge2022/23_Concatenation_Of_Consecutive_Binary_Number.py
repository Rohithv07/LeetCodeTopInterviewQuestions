Given an integer n, return the decimal value of the binary string formed by concatenating the binary representations of 1 to n in order, modulo 109 + 7.

 

Example 1:

Input: n = 1
Output: 1
Explanation: "1" in binary corresponds to the decimal value 1. 
Example 2:

Input: n = 3
Output: 27
Explanation: In binary, 1, 2, and 3 corresponds to "1", "10", and "11".
After concatenating them, we have "11011", which corresponds to the decimal value 27.
Example 3:

Input: n = 12
Output: 505379714
Explanation: The concatenation results in "1101110010111011110001001101010111100".
The decimal value of that is 118505380540.
After modulo 109 + 7, the result is 505379714.
 

Constraints:

1 <= n <= 105



class Solution:
    def concatenatedBinary(self, n: int) -> int:
        result = 0
        i = 1
        while i <= n:
            result = ((result << (1 + int(log(i, 2)))) % 1000000007 + i) % 1000000007
            i = i + 1
        return result % 10000000007
    
    
    
"""
https://www.youtube.com/watch?v=ttlNQ6YrdGs this is the reference video with good explanation


p = previously calculted value
x = current number
D = number of digits = log2(x) + 1
Then new decimal value = (p * 2 ^ D) + x
"""