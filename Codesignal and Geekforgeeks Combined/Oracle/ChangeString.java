Given a string S, the task is to change the complete string to Uppercase or Lowercase depending upon the case for the first character.

Example 1:

Input:
S = "abCD"
Output: abcd
Explanation: The first letter (a) is 
lowercase. Hence, the complete string
is made lowercase.

â€‹Example 2:

Input: 
S = "Abcd"
Output: ABCD
Explanation: The first letter (A) is
uppercase. Hence, the complete string
is made uppercase.

Your Task:
You don't need to read input or print anything. Your task is to complete the function modify() which takes the string S as input and returns the resultant string with stated modifications.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1) for C++ and O(|S|) for output in Java/Python.


Constraints:
1<=|S|<=104


//User function Template for Java

// without using any upper or lower case builtin fun
class Solution{
    String modify(String s){
        if (s == null || s.length() == 0)
            return "";
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        boolean isLower = isLowerCase(s.charAt(0));
        sb.append(s.charAt(0));
        for (int i=1; i<length; i++) {
            char current = s.charAt(i);
            if (isLower && !isLowerCase(current)) {
                current += 32;
            }
            else if (!isLower && isLowerCase(current)) {
                current -= 32;
            }
            sb.append(current);
        }
        return sb.toString();
    }
    
    boolean isLowerCase(char ch) {
        return ch >= 97 && ch <= 123;
    }
}