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
        if (word == null || word.length() == 0) {
            return false;
        }
        if (word.length() == 1) {
            return true;
        }
        int length = word.length();
        int count = 0;
        for (char ch : word.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                count++;
            }
        }
        if (count == length || count == 0) {
            return true;
        }
        return count == 1 && Character.isUpperCase(word.charAt(0));
    }
}