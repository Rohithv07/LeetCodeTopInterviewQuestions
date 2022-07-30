You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.

 

Example 1:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
Output: ["apple","google","leetcode"]
 

Constraints:

1 <= words1.length, words2.length <= 104
1 <= words1[i].length, words2[i].length <= 10
words1[i] and words2[i] consist only of lowercase English letters.
All the strings of words1 are unique.


class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList<>();
        int [] count = new int [26];
        for (String s : B) {
            int [] b = new int [26];
            for (char ch : s.toCharArray()) {
                b[ch - 'a'] += 1;
            }
            for (int i=0; i<26; i++) {
                count[i] = Math.max(count[i], b[i]);
            }
        }
        outer : for (String s : A) {
            int [] a = new int [26];
            for (char ch : s.toCharArray()) {
                a[ch - 'a'] += 1;
            }
            for (int i=0; i<26; i++) {
                if (count[i] > a[i])
                    continue outer;
            }
            result.add(s);
        }
        return result;
    }
}

