We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

 

Example 1:

Input: word = "USA"
Output: true
Example 2:

Input: word = "FlaG"
Output: false
 

Constraints:

1 <= word.length <= 100
word consists of lowercase and uppercase English letters.


class Solution {
    public boolean detectCapitalUse(String word) {
        int length = word.length();
        if (word == null || length <= 1) {
            return true;
        }
        int capCount = 0;
        boolean isFirstChar = false;
        for (int i = 0; i < length; i++) {
            char currentChar = word.charAt(i);
            if (i == 0 && isCapital(currentChar)) {
                capCount++;
                isFirstChar = true;
            }
            else if (isCapital(currentChar)) {
                capCount++;
            }
        }
        return (capCount == length) || (capCount == 1 && isFirstChar) || (capCount == 0);
    }

    private boolean isCapital(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
}