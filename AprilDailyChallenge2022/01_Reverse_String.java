Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 

Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.


class Solution {
    public void reverseString(char[] s) {
        if (s.length <= 1) {
            return;
        }
        int length = s.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }
    
    public void swap(char [] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}