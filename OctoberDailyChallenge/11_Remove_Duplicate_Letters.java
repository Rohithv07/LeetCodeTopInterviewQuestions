Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"

class Solution {
    public String removeDuplicateLetters(String s) {
        char [] sChar = s.toCharArray();
        int [] count = new int [26];
        Stack<Character> stack = new Stack();
        boolean [] visited = new boolean[26];
        // count occurance
        for (char c: sChar) {
            count[c-'a'] += 1;
        }
        for (char c: sChar) {
            count[c-'a'] -= 1;
            if (!visited[c-'a']) {
                while (!stack.isEmpty() && stack.peek()>c && count[stack.peek()-'a']>0) {
                    visited[stack.peek()-'a'] = false;
                    stack.pop();
                }
                stack.push(c);
                visited[c-'a'] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch: stack)
            sb.append(ch);
        return sb.toString();
    }
}
