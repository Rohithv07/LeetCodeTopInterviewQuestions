Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.


class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer>stack = new Stack<>();
        int calculate = 0;
        char sign = '+';
        for (int i=0; i<s.length(); i++) {
            if (Character.isDigit(s.charAt(i)))
                calculate = calculate * 10 + s.charAt(i) - '0';
            if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length() - 1) {
                if (sign == '+')
                    stack.push(calculate);
                else if (sign == '-')
                    stack.push(-calculate);
                else if (sign == '*')
                    stack.push(stack.pop() * calculate);
                else if (sign == '/')
                    stack.push(stack.pop() / calculate);
                sign = s.charAt(i);
                calculate = 0;
            }  
        }
        int result = 0;
        for (int items: stack)
            result += items;
        return result;
    }
}
