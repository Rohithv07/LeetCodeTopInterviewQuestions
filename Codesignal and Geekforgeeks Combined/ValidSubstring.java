Given a string S consisting only of opening and closing parenthesis 'ie '('  and ')', find out the length of the longest valid(well-formed) parentheses substring.
NOTE: Length of the smallest valid substring ( ) is 2.

Example 1:

Input: S = "(()("
Output: 2
Explanation: The longest valid 
substring is "()". Length = 2.
Example 2:

Input: S = "()(())("
Output: 6
Explanation: The longest valid 
substring is "()(())". Length = 6.

Your Task:  
You dont need to read input or print anything. Complete the function findMaxLen() which takes S as input parameter and returns the maxlength.


Expected Time Complexity:O(n)
Expected Auxiliary Space: O(1)   


Constraints:
1 <= |S| <= 105



class Solution {
    static int findMaxLen(String s) {
        // code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        Stack<Integer> stack = new Stack<>();
        int maximumLength = 0;
        stack.push(-1);
        for (int i=0; i<length; i++) {
            char current = s.charAt(i);
            if (current == '(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                maximumLength = Math.max(maximumLength, i - stack.peek());
            }
        }
        return maximumLength;
    }
}