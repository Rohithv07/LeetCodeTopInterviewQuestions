Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?


class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int [] count = new int [26];
        for (int i=0; i<s.length(); i++) {
            count[s.charAt(i) - 'a'] += 1;
            count[t.charAt(i) - 'a'] -= 1;
        }
        for (int number : count) {
            if (number != 0)
                return false;
        }
        return true;
    }
}
