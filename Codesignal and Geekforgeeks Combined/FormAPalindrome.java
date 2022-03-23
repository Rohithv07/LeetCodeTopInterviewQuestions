Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
For Example:
ab: Number of insertions required is 1. bab or aba
aa: Number of insertions required is 0. aa
abcd: Number of insertions required is 3. dcbabcd

Example 1:

Input:
abcd
Output:
3
Explanation:
Here we can append 3 characters in the 
beginning,and the resultant string will 
be a palindrome ("dcbabcd").
Example 2:

Input:
aba
Output:
0
Explanation:
Given string is already a pallindrome hence
no insertions are required.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function findMinInsertions() which takes string S as input parameters and returns minimimum numser of insertions required.

Expected Time Complexity: O(|S|2)
Expected Auxiliary Space: O(|S|2)

Constraints:
1 ≤ |S| ≤ 500


//User function Template for Java

class Solution{
    int findMinInsertions(String s){
        // code here
        if (s == null || s.length() <= 1) {
            return 0;
        }
        if (isPalindrome(s)) {
            return 0;
        }
        int length = s.length();
        String reversedS = findReverse(s, length);
        return length - longestCommonSubsequence(s, reversedS, length);
    }
    
    // O(n ^ 2) O(n ^ 2)
    int longestCommonSubsequence(String s1, String s2, int length) {
        int [][] dp = new int [length + 1][length + 1];
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length][length];
    }
    
    // O(n)
    String findReverse(String s, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    
    // O(n)
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
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