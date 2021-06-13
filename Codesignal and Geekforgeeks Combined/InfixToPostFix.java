Given an infix expression in the form of string str. Convert this infix expression to postfix expression.

Infix expression: The expression of the form a op b. When an operator is in-between every pair of operands.
Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.
â€‹Note: The order of precedence is: ^ greater than * equals to / greater than + equals to -. 
Example 1:

Input: str = "a+b*(c^d-e)^(f+g*h)-i"
Output: abcd^e-fgh*+^*+i-
Explanation:
After converting the infix expression 
into postfix expression, the resultant 
expression will be abcd^e-fgh*+^*+i-
Example 2:

Input: str = "A*(B+C)/D"
Output: ABC+*D/
Explanation:
After converting the infix expression 
into postfix expression, the resultant 
expression will be ABC+*D/
 
Your Task:
This is a function problem. You only need to complete the function infixToPostfix() that takes a string(Infix Expression) as a parameter and returns a string(postfix expression). The printing is done automatically by the driver code.

Expected Time Complexity: O(|str|).
Expected Auxiliary Space: O(|str|).

Constraints:
1 ≤ |str| ≤ 105


class Solution
{
    //Function to convert an infix expression to a postfix expression.
    
    public static int showPrecedence(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        if (ch == '*' || ch == '/')
            return 2;
        if (ch == '^')
            return 3;
        return -1;
    }
    
	public static String infixToPostfix(String exp) 
	{
		// Your code here
		if (exp == null || exp.length() == 0)
		    return "";
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (char ch : exp.toCharArray()) {
		    if (Character.isLetterOrDigit(ch))
		        sb.append(ch);
		    else if (ch == '(') {
		        stack.push(ch);
		    }
		    else if (ch == ')') {
		        while (!stack.isEmpty() && stack.peek() != '(') {
		            sb.append(stack.pop());
		        }
		        stack.pop();
		    }
		    // operator according to the precedence
		    else {
		        while (!stack.isEmpty() && showPrecedence(ch) <= showPrecedence(stack.peek())) {
		            sb.append(stack.pop());
		        }
		         stack.push(ch);
		    }
		}
		while (!stack.isEmpty()) {
		    sb.append(stack.pop());
		}
		return sb.toString();
	} 
}
