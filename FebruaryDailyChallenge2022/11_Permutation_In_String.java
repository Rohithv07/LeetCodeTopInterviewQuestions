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
            count[ch - 'a'] += 1;
        }
        int counterNotZero = 0;
        for (int number : count) {
            if (number != 0) {
                counterNotZero += 1;
            }
        }
        int start = 0;
        int end = 0;
        while (end < length2) {
            char currentEnd = s2.charAt(end);
            count[currentEnd - 'a'] -= 1;
            if (count[currentEnd - 'a'] == 0) {
                counterNotZero -= 1;
            }
            end++;
            while (counterNotZero == 0) {
                char currentStart = s2.charAt(start);
                count[currentStart - 'a'] += 1;
                if (count[currentStart - 'a'] > 0) {
                    counterNotZero += 1;
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