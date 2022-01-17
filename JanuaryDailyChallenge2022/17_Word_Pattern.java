Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

 

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
 

Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.



class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        int lengthOfPattern = pattern.length();
        String [] splitted = s.split(" ");
        if (lengthOfPattern != splitted.length) {
            return false;
        }
        for (int i=0; i<lengthOfPattern; i++) {
            char currentPattern = pattern.charAt(i);
            if (map.containsKey(currentPattern)) {
                if (!splitted[i].equals(map.get(currentPattern))) {
                    return false;
                }
            }
            else {
                if (map.containsValue(splitted[i])) { // contains value is having O(n) complexity
                    return false;
                }
                map.put(currentPattern, splitted[i]);
            }
        }
        return true;
    }
}