/*
You are given an integer array, bits, that only contains zeroes and ones and represents a binary sequence. Within our binary, there are two characters that are represented. One character can be represented by a single bit, 0, and another character can be represented with two bits, 10, or 11. Return whether or not the last character in our binary sequence is the character represented by a 0.
Note: The bits will always end with a zero.

Ex: Given the following bits…

bits = [1, 0, 0], return true (our binary can be decoded as our two-bit character followed by our one-bit character).
Ex: Given the following bits…

bits = [1, 0, 1, 0], return false.
*/



// if there is only single element, then the value will be true as last element is 0 always
// if the last two is 0, then also it is true
// if we have 1 before the last 0, we count the number of sequential 1 and if odd, its false, otherwise true


class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0)
            return false;
        int length = bits.length;
        int countOne = 0;
        for (int i=length-2; i>=0 && bits[i] != 0; i--) {
            countOne++;
        }
        return countOne % 2 == 0;
    }
}