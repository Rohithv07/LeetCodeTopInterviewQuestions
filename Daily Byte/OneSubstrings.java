/*
Given a binary string, binary, that contains only zero and one characters, return the total number of substrings within binary the only contain one characters.

Ex: Given the following string binary…

binary = "1011", return 4 ("1", "1", "1", and "11").
Ex: Given the following string binary…

binary = "000", return 0.
*/

class Solution {
    public int numSub(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int count = 0;
        int mod = (int)1e9 + 7;
        int length = s.length();
        int result = 0;
        for (int start=0; start<length; start++) {
            char ch = s.charAt(start);
            if (ch == '1') {
                count += 1;
            }
            else {
                count = 0;
            }
            result = (result + count) % mod;
        }
        return result;
    }
}
