Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 

Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)


Solution: 

class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        """
        if len(s) == 0:
            return False
        for elements in range(1, len(s) // 2 + 1):
            if s == s[elements:] + s[:elements]:
                return True
        return False
        """
        
        return s in s[1:] + s[:-1]
        
            
