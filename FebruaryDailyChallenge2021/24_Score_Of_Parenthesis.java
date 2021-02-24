Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:

Input: "()"
Output: 1
Example 2:

Input: "(())"
Output: 2
Example 3:

Input: "()()"
Output: 2
Example 4:

Input: "(()(()))"
Output: 6
 

Note:

S is a balanced parentheses string, containing only ( and ).
2 <= S.length <= 50



class Solution {
    public int scoreOfParentheses(String S) {
        // store the scores for the upcoming character
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (char ch : S.toCharArray()) {
            // if open push 0
            if (ch == '(') {
                stack.push(0);
            }
            // else take the last 2 top items from stack and push updated score
            // updatedscore = u + max(2 * v, 1) where u and v are the popped top items
            else {
                int top1 = stack.pop();
                int top2 = stack.pop();
                int updatedScore = top2 + Math.max(2 * top1, 1);
                stack.push(updatedScore);
            }
        }
        return stack.pop();
    }
}

/*
we have to compute the score of the balanced string
// base () - 1
(())   - 2 * inside 
()()   - 1 + 1 score

() () ()-> 1 + 1 + 1
(3)

((())) ->

result = 2 * 2 = 4

(()())

result = 1 + 1 -> temp = 1
u = 0, v = 0 -> v + Math.max(2 * u, 1) -> 0 + max(0, 1) = 1
u = 1, v = 0 -> 0 + max(2, 1) -> 2
u = 2, v = 0 -> 0 + max(4, 1) -> 4
      bottom
Stack -> 0 ->  2 -> )
*/





/*
Approach 2: O(1) Space
We count the number of layers.
If we meet '(' layers number l++
else we meet ')' layers number l--

If we meet "()", we know the number of layer outside,
so we can calculate the score res += 1 << l.

C++:

    int scoreOfParentheses(string S) {
        int res = 0, l = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S[i] == '(') l++; else l--;
            if (S[i] == ')' && S[i - 1] == '(') res += 1 << l;
        }
        return res;
    }

*/
