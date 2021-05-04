/*
Given a binary string, binary, return the maximum score of the string. The score of a string is given by splitting the string at a specific index and summing the total number of zeroes in the left substring and the total number of ones in the right substring.
Note: Both the left and right substring after the split must have at least a single character.

Ex: Given the following string binary…

binary = "10", return 0.
Ex: Given the following string binary…

binary = "0011", return 4.
*/


class Solution {
    public int maxScore(String s) {
        int length = s.length();
        int zero = 0;
        int one = 0;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<length; i++) {
            char ch = s.charAt(i);
            if (ch == '0')
                zero ++;
            else
                one ++;
            if (i != length - 1)
                max = Math.max(max, zero - one);
        }
        return max + one;
    }
}
