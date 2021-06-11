Given three strings A, B and C your task is to complete the function isInterleave which returns true if C is an interleaving of A and B else returns false. C is said to be interleaving A and B, if it contains all characters of A and B and order of all characters in individual strings is preserved.

Example 1:

Input:
A = YX, B = X, C = XXY
Output: 0
Explanation: XXY is not interleaving
of YX and X
Example 2:

Input:
A = XY, B = X, C = XXY
Output: 1
Explanation: XXY is interleaving of
XY and X.
Your Task:
Complete the function isInterleave() which takes three strings A, B and C as input and returns true if C is an interleaving of A and B else returns false. (1 is printed by the driver code if the returned value is true, otherwise 0.)

Expected Time Complexity: O(N * M)
Expected Auxiliary Space: O(N * M)
here, N = length of A, and M = length of B

Constraints:
1 ≤ length of A, B, C ≤ 100


class Solution {
	public boolean isInterLeave(String a,String b,String c)
	{
            //Your code here
        int length1 = a.length();
        int length2 = b.length();
        int length3 = c.length();
        if ((length1 + length2) != length3)
            return false;
        boolean [][] invalid = new boolean [length1 + 1][length2 + 1];
        return isValid(a, b, c, 0, 0, 0, invalid);
	}
	
	public boolean isValid(String a, String b, String c, int i, int j, int k, boolean [][] invalid) {
	    if (invalid[i][j])
	        return false;
	    if (k == c.length())
	        return true;
	    boolean valid = ((i < a.length() && k < c.length() && a.charAt(i) == c.charAt(k) && isValid(a, b, c, i+1, j, k+1, invalid)) || 
	    (j < b.length() && k < c.length() && b.charAt(j) == c.charAt(k) && isValid(a, b, c, i, j+1, k+1, invalid)));
	    if (!valid)
	        invalid[i][j] = true;
	    return valid;
	}
}


