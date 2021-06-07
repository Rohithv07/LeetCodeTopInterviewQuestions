Given a string S consisting of opening and closing parenthesis '(' and ')'. Find length of the longest valid parenthesis substring.

Example 1:

Input: S = ((()
Output: 2
Explaination: The longest valid 
parenthesis substring is "()".
Example 2:

Input: S = )()())
Output: 4
Explaination: The longest valid 
parenthesis substring is "()()".
Your Task:
You do not need to read input or print anything. Your task is to complete the function maxLength() which takes string S as input parameter and returns the length of the maximum valid parenthesis substring.

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)

Constraints:
1 ≤ |S| ≤ 105  


class Solution{
    static int maxLength(String s){
        // code here
        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int length = s.length();
        stack.push(-1);
        int result = 0;
        for (int i=0; i<length; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }
}
