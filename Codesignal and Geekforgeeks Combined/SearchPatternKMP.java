Given two strings, one is a text string, txt and other is a pattern string, pat. The task is to print the indexes of all the occurences of pattern string in the text string. For printing, Starting Index of a string should be taken as 1.


Example 1:

Input:
txt = "batmanandrobinarebat", pat = "bat"
Output: 1 18
Explanation: The string "bat" occurs twice
in txt, one starts are index 1 and the other
at index 18. 
Example 2:

Input: 
txt = "abesdu", pat = "edu"
Output: -1
Explanation: There's not substring "edu"
present in txt.

Your Task:
You don't need to read input or print anything. Your task is to complete the function search() which takes the string txt and the string pat as inputs and returns an array denoting the start indices (1-based) of substring pat in the string txt. 
Note: Return an empty list incase of no occurences of pattern. Driver will print -1 in this case.


Expected Time Complexity: O(|txt|).
Expected Auxiliary Space: O(|txt|).


Constraints:
1 ≤ |txt| ≤ 105
1 ≤ |pat| < |S|


class Solution
{
    
    // https://www.youtube.com/watch?v=V5-7GzOfADQ
    // https://github.com/mission-peace/interview/blob/master/src/com/interview/string/SubstringSearch.java
    
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        int length1 = pat.length();
        int length2 = txt.length();
        int [] lps = computeLps(pat);
        int i = 0;
        int j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (i < length2) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == length1) {
                result.add(i - j + 1);
                j = lps[j - 1];
            }
            else if (i < length2 && txt.charAt(i) != pat.charAt(j)){
                if (j != 0) {
                    j = lps[j - 1];
                }
                else {
                    i++;
                }
            }
        }
        // if (result.isEmpty()) {
        //     result.add(-11);
        // }
        return result;
    }
    
    int[] computeLps(String pat) {
        int length = pat.length();
        int [] lps = new int [length];
        int index = 0;
        for (int i=1; i<length;) {
            if (pat.charAt(i) == pat.charAt(index)) {
                lps[i] = index + 1;
                index++;
                i++;
            }
            else {
                if (index != 0) {
                    index = lps[index - 1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}