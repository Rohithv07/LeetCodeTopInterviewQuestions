Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
 

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].


class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        Stack<Integer> digits = new Stack<>();
        Stack<String> letters = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String result = "";
        int i = 0;
        while (i < length) {
            if (Character.isDigit(s.charAt(i))) {
                int number = 0;
                while (i < length && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + s.charAt(i) - '0';
                    i++;
                }
                digits.push(number);
            }
            else if (s.charAt(i) == '[') {
                letters.push(result);
                result = "";
                i++;
            }
            else if (s.charAt(i) == ']') {
                int count = digits.pop();
                StringBuilder currentlyExisting = new StringBuilder(letters.pop());
                for (int j=0; j<count; j++) {
                    currentlyExisting.append(result);
                }
                result = currentlyExisting.toString();
                i++;
            }
            else {
                result += s.charAt(i);
                i++;
            }
        }
        return result;
    }
}