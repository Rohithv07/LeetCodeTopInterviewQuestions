Given a String S, Find all possible Palindromic partitions of the given String.
 

Example 1:

Input:
S = "geeks"
Output:
g e e k s
g ee k s
Explanation:
All possible palindromic partitions
are printed.
Example 2:

Input:
S = "madam"
Output:
m a d a m
m ada m
madam

Your Task:
You don't need to read input or print anything. Your task is to complete the function allPalindromicPerms() which takes a String S as input parameter and returns a list of lists denoting all the possible palindromic partitions.

 

Expected Time Complexity: O(N*2N)
Expected Auxiliary Space: O(N2), where N is the length of the String

 

Constraints:
1 <= |S| <= 20



class Solution {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String s) {
        // code here
        if (s == null || s.length() == 0)
            return new ArrayList<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> current = new ArrayList<>();
        backtrack(result, current, s, 0);
        return result;
    }
    
    static void backtrack(ArrayList<ArrayList<String>> result, ArrayList<String> current, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i=start; i<s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                current.add(s.substring(start, i+1));
                backtrack(result, current, s, i+1);
                current.remove(current.size() - 1);
            }
        }
    }
    
    static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}
