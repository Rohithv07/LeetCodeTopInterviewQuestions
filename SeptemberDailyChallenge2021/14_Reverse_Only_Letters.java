Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

 

Example 1:

Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 

Constraints:

1 <= s.length <= 100
s consists of characters with ASCII values in the range [33, 122].
s does not contain '\"' or '\\'.


class Solution {
    public String reverseOnlyLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        if (length == 1) {
            return s;
        }
        char [] converted = s.toCharArray();
        int left = 0;
        int right = length - 1;
        while (left < right) {
            char currentLeft = s.charAt(left);
            char currentRight = s.charAt(right);
            if (Character.isLetter(currentLeft) && Character.isLetter(currentRight)) {
                swap(converted, left, right);
                left++;
                right--;
            }
            else if (!Character.isLetter(currentLeft) && !Character.isLetter(currentRight)) {
                left++;
                right--;
            }
            else if (!Character.isLetter(currentLeft)) {
                left++;
            }
            else if (!Character.isLetter(currentRight)) {
                right--;
            }
        }
        return new String(converted);
    }
    
    private void swap(char [] current, int left, int right) {
        char temp = current[left];
        current[left] = current[right];
        current[right] = temp;
    }
}