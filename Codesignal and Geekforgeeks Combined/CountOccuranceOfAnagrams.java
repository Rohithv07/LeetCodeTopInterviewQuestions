Given a word pat and a text txt. Return the count of the occurences of anagrams of the word in the text.

Example 1:

Input:
txt = forxxorfxdofr
pat = for
Output: 3
Explanation: for, orf and ofr appears
in the txt, hence answer is 3.
Example 2:

Input:
txt = aabaabaa
pat = aaba
Output: 4
Explanation: aaba is present 4 times
in txt.
Your Task:
Complete the function search() which takes two strings pat, txt, as input parameters and returns an integer denoting the answer. You don't to print answer or take inputs.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(26) or O(256)

Constraints:
1 <= |pat| <= |txt| <= 105
Both string contains lowercase english letters.

// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        if (pat == null || pat.length() == 0 || txt == null || txt.length() == 0) {
            return 0;
        }
        int lengthPat = pat.length();
        int lengthTxt = txt.length();
        int [] countPat = new int [26];
        int [] countTxt = new int [26];
        int result = 0;
        // count occurance of pat as well as what are the characters in the current window in txt
        for (int i=0; i<lengthPat; i++) {
            countPat[pat.charAt(i) - 'a'] += 1;
            countTxt[txt.charAt(i) - 'a'] += 1;
        }
        // check whether the first window have the pattern
        if (Arrays.equals(countPat, countTxt)) {
            result += 1;
        }
        // now continue checking maintaining the window
        // we need to start from the lengthPat because upto lengthPat which is the first window is already covered
        // while maintaining the window, reduce the previous windows occurance respectively
        int index = 0;
        for (int i=lengthPat; i<lengthTxt; i++) {
            // consider the current window
            countTxt[txt.charAt(i) - 'a'] += 1;
            // remove the occurance from previous window
            countTxt[txt.charAt(index) - 'a'] -= 1;
            // again check for the equality
            if (Arrays.equals(countPat, countTxt)) {
                result += 1;
            }
            index++;
        }
        return result;
    }
}