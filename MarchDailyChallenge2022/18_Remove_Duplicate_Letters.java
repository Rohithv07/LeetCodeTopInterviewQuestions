Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.


class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int [] count = new int [26];
        boolean [] visited = new boolean [26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a'] += 1;
        }
        for (char ch : s.toCharArray()) {
            count[ch - 'a'] -= 1;
            if (!visited[ch - 'a']) {
                while (!stack.isEmpty() && stack.peek() > ch && count[stack.peek() - 'a'] > 0) {
                    visited[stack.peek() - 'a'] = false;
                    stack.pop();
                }
                stack.push(ch);
                visited[ch - 'a'] = true;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}