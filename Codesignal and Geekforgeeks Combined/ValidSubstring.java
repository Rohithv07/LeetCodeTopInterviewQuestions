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



// without using stack
// use 2 variables left and right
// left track the open brackets
// right track the closed bracket
// first track the number of open and closed
// whenever we are getting into equal left and right, update the max
// if anything gets more count, reset everything to 0
// repeat the same process for right to left also


int findMaxLen(string s) {
        // code here
        int left=0,right=0;
        int length=0;
        for(int i=0;i<s.size();i++){
            if(s[i]=='('){
                left++;
            }else if(s[i]==')'){
                right++;
            }
            if(left==right){
                length=max(length,2*right);
            }
            if(right>left){
                left=right=0;
            }
        }
        left=right=0;
        for(int i=s.size()-1;i>=0;i--){
            if(s[i]=='('){
                left++;
            }else if(s[i]==')'){
                right++;
            }
            if(left==right){
                length=max(length,2*right);
            }
            if(left>right){
                left=right=0;
            }
        }
        return length;
        
    }