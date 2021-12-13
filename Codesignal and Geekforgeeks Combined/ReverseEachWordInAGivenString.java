Given a String. Reverse each word in it where the words are separated by dots.

Example 1:

Input:
S = "i.like.this.program.very.much"
Output: i.ekil.siht.margorp.yrev.hcum
Explanation: The words "i", "like",
"this", "program", "very", "much"
are all reversed.
â€‹Example 2:

Input: 
S = "pqr.mno"
Output: rqp.onm
Explanation: Both "pqr" and "mno" are
reversed.

Your Task:
You don't need to read input or print anything. Your task is to complete the function reverseWords() which takes the string S as input and returns the resultant string by reversing all the words separated by dots.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(|S|).


Constraints:
1<=|S|<=105



class Solution
{
   
    String reverseWords(String s)
    {
        // your code here
        if (s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        Stack<Character> stack = new Stack<>();
        while (start < length) {
            char current = s.charAt(start);
            if (current == '.') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(".");
            }
            else {
                stack.push(current);
            }
            start++;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}