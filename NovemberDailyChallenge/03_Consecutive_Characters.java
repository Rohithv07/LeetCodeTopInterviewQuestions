Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.

Return the power of the string.

 

Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.
Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
Example 3:

Input: s = "triplepillooooow"
Output: 5
Example 4:

Input: s = "hooraaaaaaaaaaay"
Output: 11
Example 5:

Input: s = "tourist"
Output: 1
 

Constraints:

1 <= s.length <= 500
s contains only lowercase English letters.class Solution {
    public int maxPower(String s) {
        // we can make use of 2 pointers approach
        // just have 2 pointers say left and right on the first letter
        // if move th right first and check charAT(left) == right, if yes increment the power else move the left pointer to the current position of right
        int length = s.length();
        if (length == 0)
            return 0;
        int power = 1;
        int left = 0;
        int right = 0;
        int currentPower = 0;
        while (right != length) {
            if (s.charAt(left) == s.charAt(right)) {
                currentPower += 1;
                right += 1;
                power = Math.max(currentPower, power);
            }
            else {
                left = right;
                currentPower = 0;
            }
        }
        return power;
    }
}
