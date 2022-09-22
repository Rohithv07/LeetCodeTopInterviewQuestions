Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"
 

Constraints:

1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.


class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String [] splitString = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splitString.length - 1; i++) {
            String current = splitString[i];
            StringBuilder reverseCurrent = new StringBuilder(current);
            reverseCurrent.reverse();
            String reversed = reverseCurrent.toString();
            sb.append(reversed);
            sb.append(" ");
        }
        String remaining = splitString[splitString.length - 1];
        StringBuilder reverseCurrent = new StringBuilder(remaining);
        reverseCurrent.reverse();
        String reversed = reverseCurrent.toString();
        sb.append(reversed);
        return sb.toString();
    }
}