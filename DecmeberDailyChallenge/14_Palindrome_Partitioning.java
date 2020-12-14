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
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        backtrackingHelper(result, current, s, 0);
        return result;
    }
    
    public void backtrackingHelper(List<List<String>> result, List<String> current, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList(current));
            return;
        }
        for (int i=start; i<s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                current.add(s.substring(start, i+1));
                backtrackingHelper(result, current, s, i+1);
                current.remove(current.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int start, int i) {
        int left = start;
        int right = i;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left += 1;
            right -= 1;
        }
        return true;
    }
}
