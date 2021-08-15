Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time?


class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        int [][] freq = new int [256][2];
        for (char ch : t.toCharArray()) {
            freq[ch][0] += 1;
            freq[ch][1] = 1;
        }
        int counter = 0;
        for (int [] f : freq) {
            if (f[1] == 1) {
                counter += 1;
            }
        }
        int start = 0;
        int end = 0;
        int length = Integer.MAX_VALUE;
        int windowStart = 0;
        while (end < s.length()) {
            char chEnd = s.charAt(end);
            if (freq[chEnd][1] == 1) {
                freq[chEnd][0] -= 1;
                if (freq[chEnd][0] == 0) {
                    counter -= 1;
                }
            }
            end += 1;
            while (counter == 0) {
                char chStart = s.charAt(start);
                if (freq[chStart][1] == 1) {
                    freq[chStart][0] += 1;
                    if (freq[chStart][0] > 0) {
                        counter += 1;
                    }
                }
                if (end - start < length) {
                    length = end - start;
                    windowStart = start;
                }
                start += 1;
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(windowStart, windowStart + length);
    }
}