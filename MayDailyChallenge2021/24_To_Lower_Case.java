Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

 

Example 1:

Input: s = "Hello"
Output: "hello"
Example 2:

Input: s = "here"
Output: "here"
Example 3:

Input: s = "LOVELY"
Output: "lovely"
 

Constraints:

1 <= s.length <= 100
s consists of printable ASCII characters.


class Solution {
    public String toLowerCase(String s) {
        if (s.length() == 0)
            return "";
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch >= 65 && ch <= 90) {
                sb.append((char)(ch + 32));
            }
            else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
