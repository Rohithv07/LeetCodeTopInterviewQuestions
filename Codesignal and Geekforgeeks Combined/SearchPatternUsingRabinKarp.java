Given two strings, one is a text string and other is a pattern string. The task is to print the indexes of all the occurences of pattern string in the text string. For printing, Starting Index of a string should be taken as 1.

Example 1:

Input:
S = "batmanandrobinarebat", pat = "bat"
Output: 1 18
Explanation: The string "bat" occurs twice
in S, one starts are index 1 and the other
at index 18. 
â€‹Example 2:

Input: 
S = "abesdu", pat = "edu"
Output: -1
Explanation: There's not substring "edu"
present in S.

Your Task:
You don't need to read input or print anything. Your task is to complete the function search() which takes the string S and the string pat as inputs and returns an array denoting the start indices (1-based) of substring pat in the string S. 


Expected Time Complexity: O(|S|*|pat|).
Expected Auxiliary Space: O(1).


Constraints:
1<=|S|<=105
1<=|pat|<|S|




//User function Template for Java

// https://www.geeksforgeeks.org/rabin-karp-algorithm-for-pattern-searching/

// https://youtu.be/qQ8vS2btsxI
class Solution
{
    
    ArrayList<Integer> search(String pat, String s)
    {
        // your code here
        if (pat.length() > s.length()) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(-1);
            return result;
        }
        if (s.equals(pat)) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(1);
            return result;
        }
        ArrayList<Integer> result = new ArrayList<>();
        //int hashValue = getHash(pat);
        int startingS = 0;
        int hash = 1;
        int d = 256;
        int q = 101;
        int hashOfP = 0;
        int hashOfText = 0;
        for (int i=0; i<pat.length() - 1; i++) {
            hash = (hash * d) % q;
        }
        for (int i=0; i<pat.length(); i++) {
            hashOfP = (d * hashOfP + pat.charAt(i)) % q;
            hashOfText = (d * hashOfText + s.charAt(i)) % q;
        }
        for (int i=0; i<=s.length() - pat.length(); i++) {
            if (hashOfP == hashOfText) {
                int j = 0;
                for (j=0; j<pat.length(); j++) {
                    if (s.charAt(i+j) != pat.charAt(j)) {
                        break;
                    }
                }
                if (j == pat.length()) {
                    result.add(i + 1);
                }
            }
            if (i < s.length() - pat.length()) {
                hashOfText = (d * (hashOfText - s.charAt(i) * hash) + s.charAt(i + pat.length())) % q;
                if (hashOfText < 0) {
                    hashOfText += q;
                }
            }
        }
        if (result.isEmpty()) {
            result.add(-1);
        }
        return result;
    }
}