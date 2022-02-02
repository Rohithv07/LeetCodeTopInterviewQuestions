Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int [] count = new int [26];
        for (char ch : p.toCharArray()) {
            count[ch - 'a'] += 1;
        }
        int length = s.length();
        int left = 0;
        int right = 0;
        int resultLength = p.length();
        int counter = 0;
        for (int number : count) {
            if (number != 0) {
                counter++;
            }
        }
        while (right < length) {
            char chRight = s.charAt(right);
            count[chRight - 'a'] -= 1;
            if (count[chRight - 'a'] == 0) {
                counter--;
            }
            right++;
            while (counter == 0) {
                char chLeft = s.charAt(left);
                count[chLeft - 'a'] += 1;
                if (count[chLeft - 'a'] > 0) {
                    counter++;
                }
                if (right - left == resultLength) {
                    result.add(left);
                }
                left++;
            }
        } 
        return result;
    }
}