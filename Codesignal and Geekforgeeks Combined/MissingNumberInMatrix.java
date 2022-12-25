Given a matrix of size n x n such that it has only one 0, Find the positive number (greater than zero) to be placed in place of the 0 such that sum of the numbers in every row, column and two diagonals become equal. If no such number exists, return -1.

Note: Diagonals should be only of the form matrix[i][i] and matrix[i][n-i-1]. n is always greater than 1.
 

Example 1:

Input: matrix = {{5, 5}, {5, 0}}
Output: 5
Explanation: The matrix is
5 5
5 0
Therefore If we place 5 instead of 0, all
the element of matrix will become 5. 
Therefore row 5+5=10, column 5+5=10 and 
diagonal 5+5=10, all are equal.
Example 2:

Input: matrix = {{1, 2, 0}, {3, 1, 2}, 
{2, 3, 1}}
Output: -1
Explanation: It is not possible to insert 
an element in place of 0 so that the 
condition is satisfied.thus result is -1. 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function MissingNo() which takes the matrix as input parameter and returns the number which should be placed in place of 0 such that the condition gets satisfied. If not possible return -1.
 

Expected Time Complexity: O(n * n)
Expected Space Complexity: O(2 * n)
 

Constraints:
2 <= n <= 1000
1 <= elements in the matrix <= 10^9


class Solution
{
    public long  MissingNo(int[][] matrix)
    {
        int n = matrix.length;
        long rsum[] = new long[n];
        long csum[] = new long[n];
        
        int z_x=0, z_y=0;
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                rsum[i] += matrix[i][j];
                csum[j] += matrix[i][j];
                if(matrix[i][j]==0)
                {
                    z_x=i;
                    z_y=j;
                }
            }
        }
        
        long d1 = 0, d2 = 0;
        
        for(int i=0; i<n; i++)
        {
            d1 += matrix[i][i];
            d2 += matrix[i][n-i-1];
        }
        
        
        boolean on_d1 = z_x==z_y;
        boolean on_d2 = z_x==(n-z_y-1);
        
        long ex_sum = -1;
        
        for(int i=0; i<n; i++)
        {
            if(i!=z_x && i!=z_y)
            {
                if(rsum[i]!=csum[i]) return -1;
                if(!on_d1 && rsum[i]!=d1) return -1;
                if(!on_d2 && rsum[i]!=d2) return -1;
                
                if(ex_sum>-1 && rsum[i]!=ex_sum) return -1;
                
                ex_sum = rsum[i];
                
            }
        }
        
        long ans = ex_sum - rsum[z_x];
        
        if(on_d1) d1 += ans;
        if(on_d2) d2 += ans;
        
        rsum[z_x] += ans;
        csum[z_y] += ans;
        
        if(d1!=d2) return -1;
        if(rsum[z_x]!=csum[z_y]) return -1;
        if(ans<=0) return -1;
        
        return ans;
        
        
    }
}