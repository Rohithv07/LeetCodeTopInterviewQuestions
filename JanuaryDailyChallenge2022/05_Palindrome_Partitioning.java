Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.



class Solution {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        backtrack(s, result, current, 0);
        return result;
    }
    
    public void backtrack(String s, List<List<String>> result, List<String> current, int pos) {
        if (pos == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i=pos; i<s.length(); i++) {
            if (isPalindrome(s, pos, i)) {
                current.add(s.substring(pos, i + 1));
                backtrack(s, result, current, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}