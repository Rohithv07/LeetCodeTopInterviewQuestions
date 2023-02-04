Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 > length2) {
            return false;
        }
        int [] count = new int [26];
        for (char ch : s1.toCharArray()) {
            count[ch - 'a']++;
        }
        int nonZeroCounter = 0;
        for (int c : count) {
            if (c != 0) {
                nonZeroCounter++;
            }
        }
        int start = 0;
        int end = 0;
        while (end < length2) {
            char ch = s2.charAt(end);
            count[ch - 'a']--;
            if (count[ch - 'a'] == 0) {
                nonZeroCounter--;
            }
            end++;
            while (nonZeroCounter == 0) {
                char front = s2.charAt(start);
                count[front - 'a']++;
                if (count[front - 'a'] > 0) {
                    nonZeroCounter++;
                }
                if (end - start == length1) {
                    return true;
                }
                start++;
            }
        }
        return false;
    }
}