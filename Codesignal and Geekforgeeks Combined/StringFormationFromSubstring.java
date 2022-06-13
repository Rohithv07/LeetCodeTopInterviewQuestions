Given a string s, the task is to check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. 

Example 1:

Input: s = "ababab"
Output: 1
Explanation: It is contructed by 
appending "ab" 3 times
Example 2:

Input: s = "ababac"
Output: 0
Explanation: Not possible to construct
User Task:
Your task is to complete the function isRepeat() which takes a single string as input and returns 1 if possible to construct, otherwise 0. You do not need to take any input or print anything.

Expected Time Complexity: O(|s|)
Expected Auxiliary Space: O(|s|)

Constraints:
1 <= |s| <= 105

//User function Template for Java

// the most optimal solution is by using KMP algorithm

class Solution {
    int isRepeat(String s) {
        // code here
        if (s.length() <= 1) {
            return 0;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return 1;
            }
            return 0;
        }
        String combined = s + s;
        String substring = combined.substring(1, combined.length() - 2);
        if (substring.indexOf(s) != -1) {
            return 1;
        }
        return 0;
    }
}