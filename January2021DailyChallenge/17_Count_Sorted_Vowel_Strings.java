Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

 

Example 1:

Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
Example 2:

Input: n = 2
Output: 15
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
Example 3:

Input: n = 33
Output: 66045
 

Constraints:

1 <= n <= 50 



class Solution {
    public int countVowelStrings(int n) {
        // return ((n + 1) * (n + 2) * (n + 3) * (n + 4) / 24); O(1) time solution
        int [] dp = new int [6];
        for (int i=1; i<dp.length; i++)
            dp[i] = 1;
        for (int i=1; i<=n; i++) {
            for (int k=1; k<=5; k++) {
                dp[k] += dp[k - 1];
            }
        }
        return dp[5];
    }
}
