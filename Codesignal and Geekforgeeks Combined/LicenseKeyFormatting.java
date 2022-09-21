Given a string S that consists of only alphanumeric characters and dashes. The string is separated into N + 1 groups by N dashes. Also given an integer K. 

We want to reformat the string S, such that each group contains exactly K characters, except for the first group, which could be shorter than K but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.

Return the reformatted string.


Example 1:

Input: 
S = "5F3Z-2e-9-w", K = 4
Output: "5F3Z-2E9W"
Explanation: The string S has been split into two
parts, each part has 4 characters. Note that two
extra dashes are not needed and can be removed.
Example 2:

Input:
S = "2-5g-3-J", K = 2
Output: "2-5G-3J"
Explanation: The string s has been split 
into three parts, each part has 2 characters 
except the first part as it could
be shorter as mentioned above.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function ReFormatString() which takes a string S and an integer K as input and returns the reformatted string.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ S.length() ≤ 105
1 ≤ K ≤ 104



// User function Template for Java

class Solution{
    static String ReFormatString(String s, int k){
        // code here
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int i = length - 1;
        while (i >= 0) {
            int temp = k;
            while (i >= 0 && temp > 0) {
                char ch = s.charAt(i);
                if (ch != '-') {
                    sb.append(ch);
                    temp--;
                }
                i--;
                
            }
            sb.append("-");
        }
        i = sb.length() - 1;
        while (i >= 0) {
            if (sb.charAt(i) == '-')
                sb.deleteCharAt(i);
            else {
                break;
            }
            i--;
        }
        return sb.reverse().toString().toUpperCase();
    }
}