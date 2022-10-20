Given a matrix as 2D array. Find the reverse spiral traversal of the matrix. 

Example 1:

Input: R = 3, C = 3
  a = {{9, 8, 7},
       {6, 5, 4},
       {3, 2, 1}}
Output: 5 6 3 2 1 4 7 8 9
Explanation: Spiral form of the matrix
in reverse order starts from the centre 
and goes outward.


Example 2:

Input: R = 4, C = 4 
  a = {{1, 2, 3, 4},
       {5, 6, 7, 8},
       {9, 10, 11, 12}, 
       {13, 14, 15, 16}}
Output: 10 11 7 6 5 9 13 14 15 16 12 8 4 3 2 1
Explanation: 


Your Task:  
You dont need to read input or print anything. Complete the function reverseSpiral() which takes R, C and a as input parameters and returns the matrix in reverse spiral form.

Expected Time Complexity: O(R*C)
Expected Auxiliary Space: O(R*C)

Constraints:
1 <= R,C <=100
1 <= a[R][C] <=100



//User function Template for Java
class Solution
{
    public int[] reverseSpiral(int r, int c, int[][] a)
    {
        // code here
        int [] result = new int [r * c];
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = r - 1;
        int colEnd = c - 1;
        int index = r * c - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            int i = colStart;
            int j = 0;
            while (i <= colEnd) {
                result[index--] = a[rowStart][i];
                i++;
            }
            rowStart++;
            j = rowStart;
            while (j <= rowEnd) {
                result[index--] = a[j][colEnd];
                j++;
            }
            colEnd--;
            if (rowStart <= rowEnd) {
                i = colEnd;
                while (i >= colStart) {
                    result[index--] = a[rowEnd][i];
                    i--;
                }
                rowEnd--;
            }
            if (colStart <= colEnd) {
                j = rowEnd;
                while (j >= rowStart) {
                    result[index--] = a[j][colStart];
                    j--;
                }
                colStart++;
            }
        }
        return result;
    }
}