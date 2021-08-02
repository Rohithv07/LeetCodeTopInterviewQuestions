/*
Given two strings, s and t, merge the two strings together alternating characters starting with s.
Note: If one string is longer than the other, append the remaining characters of the longer string at the end of the merged string.


s = "abc", t = "def", return "adbecf".
*/


class Solution {
    public String mergeAlternately(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < length1 && j < length2) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        while (i < length1) {
            sb.append(word1.charAt(i++));
        }
        while (j < length2) {
            sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
}