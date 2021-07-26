/*
Given a string s and an integer k, return the length of the longest substring in s you can create that contains a single capital letter. You may apply k operations to s where a single operation consists of selecting one capital letter and modifying it to be another capital letter.
Note: s will only contain uppercase alphabetical characters.

Ex: Given the following s and k…

s = "BBAA", k = 2, return 4 (both B's can be changed to A's or both A's can be changed to B's).
*/



class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;
        int [] count = new int [26];
        int start = 0;
        int maxLength = 0;
        int maxCount = 0; // maximum count of the unique character in the current window
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            maxCount = Math.max(maxCount, ++count[ch - 'A']);
            while (end - start + 1 - maxCount > k) {
                char startCh = s.charAt(start);
                count[startCh - 'A'] -= 1;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}