Given two strings A and B. Find the minimum number of steps required to transform string A into string B. The only allowed operation for the transformation is selecting a character from string A and inserting it in the beginning of string A.

Example 1:

Input:
A = "abd"
B = "bad"
Output: 1
Explanation: The conversion can take place in
1 operation: Pick 'b' and place it at the front.
Example 2:

Input:
A = "GeeksForGeeks"
B = "ForGeeksGeeks"
Output: 3
Explanation: The conversion can take
place in 3 operations:
Pick 'r' and place it at the front.
A = "rGeeksFoGeeks"
Pick 'o' and place it at the front.
A = "orGeeksFGeeks"
Pick 'F' and place it at the front.
A = "ForGeeksGeeks"
Your Task: 
You dont need to read input or print anything. Complete the function transform() which takes two strings A and B as input parameters and returns the minimum number of steps required to transform A into B. If transformation is not possible return -1.


Expected Time Complexity: O(N) where N is max(length of A, length of B) 
Expected Auxiliary Space: O(1)  


Constraints:
1<= A.length(), B.length() <= 104



class Solution
{
    int transform (String a, String b)
    {
        // code here
        int [] count = new int [256];
        for (char ch : a.toCharArray()) {
            count[ch] ++;
        }
        for (char ch : b.toCharArray()) {
            count[ch] --;
        }
        for (int num : count) {
            if (num != 0) {
                return -1;
            }
        }
        int length = a.length();
        int i = length - 1;
        int j = length - 1;
        int counts = 0;
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == b.charAt(j)) {
                i--;
                j--;
            }
            else {
                counts++;
                i--;
            }
        }
        return counts;
    }
}