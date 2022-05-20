Imagine you have a special keyboard with all keys in a single row. The layout of characters on a keyboard is denoted by a string S1 of length 26. S1 is indexed from 0 to 25. Initially, your finger is at index 0.
To type a character, you have to move your finger to the index of the desired character. The time taken to move your finger from index i to index j is |j-i|, where || denotes absolute value.Find the time taken to type the string S2 with the given keyboard layout.


Example 1:

Input: 
S1 = "abcdefghijklmnopqrstuvwxyz"
S2 = "cba"
Output: 
4
Explanation:
Initially we are at index 0. To type 'c',
it will take a time of abs(0-2) = 2. To, type
'b' next, it will take abs(2-1) = 1. And, for
'a', it will take abs(1-0) = 1 unit time.
So, total time = 2+1+1 = 4.
Example 2:

Input: 
S1 = "zyxwvutsrqponmlkjihgfedcba"
S2 = "a"
Output: 
25
Explanation:
'a' is at index 25. So, the time taken
to type 'a' will be abs(0-25) = 25.

Your Task:
You don't need to read input or print anything. You only need to complete the function findTime() that takes two strings S1, and S2 as input and returns an integer denoting time taken to type the string S2.


Expected Time Complexity:  O(|S2|)
Expected Auxilliary Space: O(1)
 

Constraints:
1 < |S2| < 105
Length of S1 is 26
S1 contains all 26 alphabets in lower case



class Solution {
    static int findTime(String s1 , String s2) {
        // code here
        if (s1.equals(s2)) {
            return s1.length();
        }
        int timeTaken = 0;
        int [] indexMap = new int [26];
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            indexMap[ch - 'a'] = i;
        }
        int previousIndex = 0;
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            int currentIndex = indexMap[ch - 'a'];
            timeTaken += Math.abs(currentIndex - previousIndex);
            previousIndex = currentIndex;
        }
        return timeTaken;
    }
}