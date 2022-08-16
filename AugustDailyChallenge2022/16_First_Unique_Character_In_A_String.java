Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.


class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        int length = s.length();
        int [] count = new int [26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (count[ch - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}