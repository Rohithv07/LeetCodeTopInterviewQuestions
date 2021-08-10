A binary string is monotone increasing if it consists of some number of 0's (possibly none), followed by some number of 1's (also possibly none).

You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.

Return the minimum number of flips to make s monotone increasing.

 

Example 1:

Input: s = "00110"
Output: 1
Explanation: We flip the last digit to get 00111.
Example 2:

Input: s = "010110"
Output: 2
Explanation: We flip to get 011111, or alternatively 000111.
Example 3:

Input: s = "00011000"
Output: 2
Explanation: We flip to get 00000000.
 

Constraints:

1 <= s.length <= 105
s[i] is either '0' or '1'.



class Solution {
    public int minFlipsMonoIncr(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int countOfOne = 0;
        int minFlip = 0;
        int zeroCountFromBack = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                countOfOne += 1;
            }
        }
        minFlip = countOfOne;
        for (int i=s.length() - 1; i>=0; i--) {
            if (s.charAt(i) == '0') {
                zeroCountFromBack += 1;
            }
            else {
                countOfOne -= 1;
            }
            minFlip = Math.min(zeroCountFromBack + countOfOne, minFlip);
        }
        return minFlip;
    }
}