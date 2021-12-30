Given string S representing a postfix expression, the task is to evaluate the expression and find the final value. Operators will only include the basic arithmetic operators like *, /, + and -.

 

Example 1:

Input: S = "231*+9-"
Output: -4
Explanation:
After solving the given expression, 
we have -4 as result.
Example 2:

Input: S = "123+*8-"
Output: -3
Explanation:
After solving the given postfix 
expression, we have -3 as result.

Your Task:
You do not need to read input or print anything. Complete the function evaluatePostfixExpression() that takes the string S denoting the expression as input parameter and returns the evaluated value.


Expected Time Complexity: O(|S|)
Expected Auixilliary Space: O(|S|)


Constraints:
1 ≤ |S| ≤ 105

0 ≤ |Si|≤ 9 (And given operators)


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String s)
    {
        // Your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            }
            else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (ch == '+') {
                    result = (num2 + num1);
                }
                else if (ch == '-') {
                    result = (num2 - num1);
                }
                else if (ch == '*') {
                    result = (num2 * num1);
                }
                else {
                    result = (num2 / num1);
                }
                stack.push(result);
            }
        }
        return result;
    }
}