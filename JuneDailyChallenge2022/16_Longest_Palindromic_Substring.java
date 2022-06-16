Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.



class Solution {
    
    private int resultStart;
    private int resultLength;
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int length = s.length();
        for (int start = 0; start < length - 1; start++) {
            expandFromMiddle(s, start, start);
            expandFromMiddle(s, start, start + 1);
        }
        return s.substring(resultStart, resultStart + resultLength);
    }
    
    private void expandFromMiddle(String s, int start, int end) {
        int length = s.length();
        while (start >= 0 && end < length && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (end - start - 1 > resultLength) {
            resultLength = end - start - 1;
            resultStart = start + 1;
        }
    }
}