Given a string and number of rows ‘n’. Print the string formed by concatenating n rows when the input string is written in row-wise Zig-Zag fashion.

Example 1:

Input: 
str = "ABCDEFGH"
n = 2
Output: "ACEGBDFH"
Explanation: 
Let us write input string in 
Zig-Zag fashion in 2 rows.
A   C   E   G  
  B   D   F   H
Now concatenate the two rows and ignore 
spaces in every row. We get "ACEGBDFH"
Example 2:

Input: 
str = "GEEKSFORGEEKS"
n = 3
Output: GSGSEKFREKEOE
Explanation: 
Let us write input string in 
Zig-Zag fashion in 3 rows.
G       S       G       S
  E   K   F   R   E   K
    E       O       E
Now concatenate the two rows and ignore spaces
in every row. We get "GSGSEKFREKEOE"
Your Task:
You need not read input or print anything. Your task is to complete the function convert() which takes 2 arguments(string str, integer n) and returns the resultant string.

Expected Time Complexity: O(|str|).
Expected Auxiliary Space: O(|str|).

Constraints:
1 ≤ N ≤ 105



//User function Template for Java

class Solution
{
    String convert(String s, int n)
    {
        //code here
        if (n <= 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        StringBuilder [] buildChar = new StringBuilder[n];
        for (int i=0; i<n; i++) {
            buildChar[i] = new StringBuilder();
        }
        //Arrays.fill(buildChar, new StringBuilder());
        int row = 0;
        int directions = -1; // -1 means down and +1 means up
        for (char ch : s.toCharArray()) {
            buildChar[row].append(ch);
            if (row == 0 || row == n - 1) {
                directions = 0 - directions;
            }
            row += directions;
        }
        for (int i=0; i<n; i++) {
            result.append(buildChar[i]);
        }
        return result.toString();
        
    }
}