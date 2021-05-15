A valid number can be split up into these components (in order):

A decimal number or an integer.
(Optional) An 'e' or 'E', followed by an integer.
A decimal number can be split up into these components (in order):

(Optional) A sign character (either '+' or '-').
One of the following formats:
At least one digit, followed by a dot '.'.
At least one digit, followed by a dot '.', followed by at least one digit.
A dot '.', followed by at least one digit.
An integer can be split up into these components (in order):

(Optional) A sign character (either '+' or '-').
At least one digit.
For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"], while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].

Given a string s, return true if s is a valid number.

 

Example 1:

Input: s = "0"
Output: true
Example 2:

Input: s = "e"
Output: false
Example 3:

Input: s = "."
Output: false
Example 4:

Input: s = ".1"
Output: true
 

Constraints:

1 <= s.length <= 20
s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+', minus '-', or dot '.'.


class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        int length = s.length();
        // if (length == 0 || s == null)
        //     return false;
        boolean numberSeen = false;
        boolean eSeen = false;
        boolean pointSeen = false;
        for (int i=0; i<length; i++) {
            char ch = s.charAt(i);
            if ('0' <= ch && ch <= '9')
                numberSeen = true;
            else if (ch == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            }
            else if (ch == 'e' || ch == 'E') {
                if (eSeen || !numberSeen)
                    return false;
                numberSeen = false;
                eSeen = true;
            }
            else if (ch == '-' || ch == '+') {
                if (i > 0 && s.charAt(i - 1) != 'e')
                    return false;
            }
            else {
                return false;
            }
        }
        return numberSeen;
    }
}
