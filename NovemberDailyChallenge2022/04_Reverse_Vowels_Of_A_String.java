Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"
 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.


class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char [] converted = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !set.contains(converted[left])) {
                left++;
            }
            while (left < right && !set.contains(converted[right])) {
                right--;
            }
            swap(converted, left, right);
            left++;
            right--;
        }
        return new String(converted);
    }
    
    public void swap(char [] converted, int left, int right) {
        char temp = converted[left];
        converted[left] = converted[right];
        converted[right] = temp;
    }
}