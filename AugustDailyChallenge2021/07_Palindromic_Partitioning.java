Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
Example 2:

Input: s = "a"
Output: 0
Example 3:

Input: s = "ab"
Output: 1
 

Constraints:

1 <= s.length <= 2000
s consists of lower-case English letters only.


class Solution {
    private Integer[][] dp;
    private Boolean [][] palindrome;
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        dp = new Integer[length][length];
        palindrome = new Boolean [length][length];
        return findCut(s, 0, length - 1);
    }
    
    public int findCut(String s, int start, int end) {
        if (start == end || isPalindrome(s, start, end))
            return 0;
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        int cut = s.length() - 1;
        for (int i=start; i<=end; i++) {
            if (isPalindrome(s, start, i)) {
                cut = Math.min(cut, 1 + findCut(s, i+1, end));
            }
        }
        return dp[start][end] = cut;
    }
    
    public boolean isPalindrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (palindrome[start][end] != null) {
            return palindrome[start][end];
        }
        return palindrome[start][end] = s.charAt(start) == s.charAt(end) && isPalindrome(s, start + 1, end - 1);
    }
}
