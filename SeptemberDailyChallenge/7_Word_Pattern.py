Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.


Solution:

from collections import OrderedDict
class Solution:
    def wordPattern(self, pattern: str, str: str) -> bool:
        list2 = str.split(' ')
        if len(pattern) != len(list2):
            return False
        dictionary = OrderedDict()
        for i in range(len(pattern)):
            if pattern[i] not in dictionary:
                if list2[i] not in dictionary.values():
                    dictionary[pattern[i]] = list2[i]
                else:
                    return False
        modifiedString = ' '.join(dictionary[i] for i in pattern)      
        return str == modifiedString
