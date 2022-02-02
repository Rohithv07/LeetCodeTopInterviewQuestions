Given a positive integer N, return its corresponding column title as it would appear in an Excel sheet.
For N =1 we have column A, for 27 we have AA and so on.

Note: The alphabets are all in uppercase.

Example 1:

Input:
N = 51
Output: AY
Your Task:
Complete the function ExcelColumn() which takes N as input and returns output string.

Expected Time Complexity: O(Log(N))
Expected Auxiliary Space: O(Log(N))

Constraints:
1 ≤ N ≤ 107


//User function Template for Java

class Solution {
    public String excelColumn(int n){
        
        //  Your code here
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            sb.insert(0, (char)('A' + n % 26));
            n /= 26;
        }
        return sb.toString();
        
    }
}