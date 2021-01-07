Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.



class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int pointer1 = 0;
        int pointer2 = 0;
        int length = s.length();
        int maximumLength = 0;
        Set<Character> trackUnique = new HashSet<>();
        while (pointer2 < length) {
            if (!trackUnique.contains(s.charAt(pointer2))) {
                trackUnique.add(s.charAt(pointer2));
                pointer2 += 1;
                maximumLength = Math.max(maximumLength, trackUnique.size());
            }
            else {
                trackUnique.remove(s.charAt(pointer1));
                pointer1 += 1;
            }
        }
        return maximumLength;
    }
}
