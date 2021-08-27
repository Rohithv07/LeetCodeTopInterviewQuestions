Given an array of strings strs, return the length of the longest uncommon subsequence between them. If the longest uncommon subsequence does not exist, return -1.

An uncommon subsequence between an array of strings is a string that is a subsequence of one string but not the others.

A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.

For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in "aebdc" to get "abc". Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).
 

Example 1:

Input: strs = ["aba","cdc","eae"]
Output: 3
Example 2:

Input: strs = ["aaa","aaa","aa"]
Output: -1
 

Constraints:

1 <= strs.length <= 50
1 <= strs[i].length <= 10
strs[i] consists of lowercase English letters.


class Solution {
    public int findLUSlength(String[] strs) {
        if (strs == null || strs.length == 0)
            return -1;
        // 1. sort in reversing order
        Arrays.sort(strs, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
        // 2. Find the duplicates if any
        // if no duplicates then the longest string is the answer
        Set<String> duplicates = findDuplicate(strs);
        if (duplicates.size() == 0) {
            return strs[0].length();
        }
        // check for other strings that are not duplicate
        // skip which are common
        for (int i=0; i<strs.length; i++) {
            if (!duplicates.contains(strs[i])) {
                if (i == 0)
                    return strs[i].length();
                for (int j=0; j<i; j++) {
                    if (isSubsequence(strs[j], strs[i]))
                        break;
                    if (j == i - 1)
                        return strs[i].length();
                }
            }
        }
        return -1;
    }
    
    public boolean isSubsequence(String s1, String s2) {
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == s2.length();
    }
    
    public Set<String> findDuplicate(String [] strs) {
        Set<String> store = new HashSet<>();
        Set<String> duplicate = new HashSet<>();
        for (String s : strs) {
            if (store.contains(s)) {
                duplicate.add(s);
            }
            else {
                store.add(s);
            }
        }
        return duplicate;
    }
}