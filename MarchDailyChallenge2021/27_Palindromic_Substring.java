Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
 

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

Note:

The input string length won't exceed 1000.



class Solution {
    public int countSubstrings(String s) {
        if (s.length() < 2)
            return s.length();
        int result = 0;
        int length = s.length();
        for (int i=0; i<length; i++) {
            result += palindromicSubstring(s, i, i);
            result += palindromicSubstring(s, i, i+1);
        }
        return result;
    }
    
    public int palindromicSubstring(String s, int start, int end) {
        int length = s.length();
        int count = 0;
        while (start >= 0 && end < length && s.charAt(start) == s.charAt(end)) {
            count += 1;
            start -= 1;
            end += 1;
        }
        return count;
    }
}
