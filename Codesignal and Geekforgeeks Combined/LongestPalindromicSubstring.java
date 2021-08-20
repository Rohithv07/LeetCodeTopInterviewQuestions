Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index ).


Example 1:

Input:
S = "aaaabbaa"
Output:
aabbaa
Explanation:
The longest palindrome string present in
the given string is "aabbaa".

Your Task:  
You don't need to read input or print anything. Your task is to complete the function longestPalindrome() which takes string S as input parameters and returns longest pallindrome present in string.


Expected Time Complexity: O(|S|2)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ |S| ≤ 104


class Solution{
    private int resultStart;
    private int resultLength;
    String longestPalindrome(String s){
        // code here
        if (s == null || s.length() == 0)
            return "";
        if (s.length() == 1) {
            return s;
        }
        int length = s.length();
        for (int start=0; start<length-1; start++) {
            widerange(s, start, start);
            widerange(s, start, start+1);
        }
        return s.substring(resultStart, resultStart + resultLength);
    }
    
    void widerange(String s, int start, int end) {
        while (start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start -= 1;
            end += 1;
        }
        if (resultLength < end - start - 1) {
            resultLength = end - start - 1;
            resultStart = start + 1;
        }
    }
}