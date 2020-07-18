Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
 

Note: You may assume the string contains only lowercase English letters.

Solution:

class Solution:
    def firstUniqChar(self, s: str) -> int:
        length = len(s)
        for i in range(0, length):
            if s[i] not in s[:i]+s[i+1:]:
                return i
            
        return -1
            
