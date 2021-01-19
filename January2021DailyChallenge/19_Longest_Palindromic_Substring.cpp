Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),




class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.length();
        int bestLength = 0;
        string bestString = "";
        for (int mid=0; mid<n; mid++) {
            for (int x=0; mid-x>=0 && x+mid<n; x++) {
                if (s[mid-x] != s[mid+x])
                    break;
                int length = 2 * x + 1;
                if (length > bestLength) {
                    bestLength = length;
                    bestString = s.substr(mid-x, length);
                }
            }
        }
        for (int mid=0; mid<n; mid++) {
            for (int x=0; mid-x+1 >= 0 && mid + x < n; x++) {
                if (s[mid-x+1] != s[mid+x])
                    break;
                int length = 2 * x;
                if (length > bestLength) {
                    bestLength = length;
                    bestString = s.substr(mid-x+1, length);
                }
            }
        }
        return bestString;
    }
};
