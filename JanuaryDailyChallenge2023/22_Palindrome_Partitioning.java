Given a string s, partition s such that every 
substring
 of the partition is a 
palindrome
. Return all possible palindrome partitioning of s.

 

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
        int length = s.length();
        if (s == null || length == 0) {
            return result;
        }
        List<String> current = new ArrayList<>();
        backtrack(s, result, current, 0);
        return result;
    }

    private void backtrack(String s, List<List<String>> result, List<String> current, int index) {
        if (index >= s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        // pick and not pick
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                String palindrome = s.substring(index, i + 1);
                current.add(palindrome);
                backtrack(s, result, current, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        if (s.length() == 1) {
            return true;
        }
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}