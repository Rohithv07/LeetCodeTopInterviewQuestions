The power of the string is the maximum length of a non-empty substring that contains only one unique character.

Given a string s, return the power of s.

 

Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.
Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
Example 3:

Input: s = "triplepillooooow"
Output: 5
Example 4:

Input: s = "hooraaaaaaaaaaay"
Output: 11
Example 5:

Input: s = "tourist"
Output: 1
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters.



class Solution {
    public int maxPower(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int length = s.length();
        int result = 0;
        for (int i=0; i<length; i++) {
            int j = i + 1;
            while (j < length && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            result = Math.max(result, j - i);
        }
        return result;
    }
}



class Solution {
    public int maxPower(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int length = s.length();
        int start = 0;
        int end = 0;
        int result = 0;
        int current = 0;
        while (end < length) {
            if (s.charAt(start) == s.charAt(end)) {
                current++;
                if (current > result) {
                    result = current;
                }
                end++;
            }
            else {
                current = 0;
                start = end;
            }
        }
        return result;
    }
}