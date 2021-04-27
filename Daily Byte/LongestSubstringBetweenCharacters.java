/*
Given a string, s, return the length of the longest substring between two characters that are equal.
Note: s will only contain lowercase alphabetical characters.

Ex: Given the following string s…

s = "bbccb", return 3 ("bcc" is length 3).
Ex: Given the following string s…

s = "abb", return 0.
*/



class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int length = s.length();
        if (length <= 1)
            return -1;
        Map<Character, Integer> map = new HashMap<>();
        int result = -1;
        for (int i=0; i<length; i++) {
            if (map.containsKey(s.charAt(i))) {
                result = Math.max(result, i - map.get(s.charAt(i)) - 1);
            }
            else {
                map.put(s.charAt(i), i);
            }
        }
        return result;
    }
}
