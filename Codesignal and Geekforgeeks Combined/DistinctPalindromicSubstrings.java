Given a string str of lowercase ASCII characters, Count the number of distinct continuous palindromic sub-strings which are present in the string str.

Example 1:

Input:
str = "abaaa"
Output:
5
Explanation : These are included in answer:
"a","aa","aaa","aba","b"
Example 2:

Input
str = "geek"
Output: 
4
Explanation : Below are 4 palindrome sub-strings
"e","ee","g","k"
Your Task:
You don't need to read input or print anything. Your task is to complete the function palindromeSubStrs() which takes the string str as input parameter and returns the total number of distinct continuous palindromic sub-strings in str.

Expected Time Complexity : O(N2logN)
Expected Auxilliary Space : O(N2)

Constraints:
1 ≤ N ≤ 2*103, where N is the length of the string str.


class Solution 
{ 
    int palindromeSubStrs(String str) { 
        // code here     
        int length = str.length();
        if (length == 1) {
            return 1;
        }
        Set<String> track = new HashSet<>();
        for (int i=0; i<length; i++) {
            expand(str, i, i, track);
            expand(str, i, i + 1, track);
        }
        return track.size();
    }
    
    public void expand(String s, int i, int j, Set<String> set) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            set.add(s.substring(i, j + 1));
            i--;
            j++;
        }
    }
} 