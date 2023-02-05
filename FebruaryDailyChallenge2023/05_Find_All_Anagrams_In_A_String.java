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
        if (s.equals(p)) {
            result.add(0);
            return result;
        }
        int lengthS = s.length();
        int lengthP = p.length();
        if (lengthP > lengthS) {
            return result;
        }
        int [] count = new int [26];
        int nonZeroCount = 0;
        int start = 0;
        int end = 0;
        for (char ch : p.toCharArray()) {
            count[ch - 'a']++;
        }
        for (int c : count) {
            if (c != 0) {
                nonZeroCount++;
            }
        }
        while (end < lengthS) {
            char chEnd = s.charAt(end);
            count[chEnd - 'a']--;
            if (count[chEnd - 'a'] == 0) {
                nonZeroCount--;
            }
            end++;
            while (nonZeroCount == 0) {
                char chStart = s.charAt(start);
                count[chStart - 'a']++;
                if (count[chStart - 'a'] > 0) {
                    nonZeroCount++;
                }
                if (end - start == lengthP) {
                    result.add(start);
                }
                start++;
            }
        }
        return result;
    }
}