Given a balanced parentheses string s, return the score of the string.

The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:

Input: s = "()"
Output: 1
Example 2:

Input: s = "(())"
Output: 2
Example 3:

Input: s = "()()"
Output: 2
 

Constraints:

2 <= s.length <= 50
s consists of only '(' and ')'.
s is a balanced parentheses string.



class Solution {
    public int scoreOfParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        if (s.length() == 2) {
            return 1;
        }
        int length = s.length();
        Stack<Integer> stack = new Stack<>(); // pushing the score
        stack.push(0);
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(0);
            }
            else {
                // take the top 2 element
                // update stack as top2 + max(2 * top1, 1);
                int top1 = stack.pop();
                int top2 = stack.pop();
                int updatedScore = top2 + Math.max(2 * top1, 1);
                stack.push(updatedScore);
            }
        }
        return stack.pop();
    }
}


// space otpimised

class Solution {
    public int scoreOfParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        if (s.length() == 2) {
            return 1;
        }
        int length = s.length();
        // we can optimise the space
        // whenever we see a (, then increase counter or layer
        // else decrease it
        // if current char is closed and previous one is open, update our result as 2 ^ count or 1 << counter
        // consider it as a tree like structure for more simplicity
        int layer = 0;
        int result = 0;
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                layer++;
            }
            else {
                layer--;
            }
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                result += 1 << layer; // same as 1 * (2 ^ layer)
            }
        }
        return result;
    }
}