Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 

Constraints:

1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.
 




class Solution {
    public boolean backspaceCompare(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
                else {
                    continue;
                }
            }
            else {
                stack1.push(ch);
            }
        }
        for (char ch : t.toCharArray()) {
            if (ch == '#') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
                else {
                    continue;
                }
            }
            else {
                stack2.push(ch);
            }
        }
        if (stack1.size() != stack2.size()) {
            return false;
        }
        int size = stack1.size();
        for (int i = 0; i < size; i++) {
            char ch1 = stack1.pop();
            char ch2 = stack2.pop();
            if (ch1 != ch2) {
                return false;
            }
        }
        return true;
    }
}