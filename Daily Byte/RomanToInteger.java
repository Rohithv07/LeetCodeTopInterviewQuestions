/*
Given a string, s, that represents a Roman numeral, return its associated integer value.
Note: You may assume that each string represents a valid Roman numeral and its value will not exceed one thousand.
Ex: Given the following string s...

s = "DCLII", return 652.
Ex: Given the following string s...

s = "VIII", return 8.
*/

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        StringBuilder sb = new StringBuilder(s);
        String reversed = sb.reverse().toString();
        int result = map.get(reversed.charAt(0));
        for (int i=1; i<s.length(); i++) {
            if (map.get(reversed.charAt(i)) >= map.get(reversed.charAt(i - 1))) {
                result += map.get(reversed.charAt(i));
            }
            else {
                result -= map.get(reversed.charAt(i));
            }
        }
        return result;
    }
}
