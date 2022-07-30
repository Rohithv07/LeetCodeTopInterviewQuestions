Given a string consisting of lowercase english alphabets. Find the repeated character present first in the string.

Example 1:

Input:
S = "geeksforgeeks"
Output: g
Explanation: g, e, k and s are the repeating
characters. Out of these, g occurs first. 
Example 2:

Input: 
S = "abcde"
Output: -1
Explanation: No repeating character present.

Your Task:
You don't need to read input or print anything. Your task is to complete the function firstRep() which takes the string S as input and returns the the first repeating character in the string. In case there's no repeating character present, return '#'.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).


Constraints:
1<=|S|<=105





//User function Template for Java

// another solution is to traverse from back to front and store a variable result
// which stores the char whenver we have a count >= 2
class Solution
{
    char firstRep(String s)
    {
        // your code here
        if (s == null || s.length() == 0) {
            return '#';
        }
        int [] count = new int [26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a'] += 1;
        }
        for (char ch : s.toCharArray()) {
            if (count[ch - 'a'] >= 2) {
                return ch;
            }
        }
        return '#';
    }
}