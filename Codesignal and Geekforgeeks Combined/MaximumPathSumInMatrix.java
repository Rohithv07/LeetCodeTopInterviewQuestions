Given a NxN matrix of positive integers. There are only three possible moves from a cell Matrix[r][c].

Matrix [r+1] [c]
Matrix [r+1] [c-1]
Matrix [r+1] [c+1]
Starting from any column in row 0 return the largest sum of any of the paths up to row N-1.

Example 1:

Input: N = 2
Matrix = {{348, 391},
          {618, 193}}
Output: 1009
Explaination: The best path is 391 -> 618. 
It gives the sum = 1009.

Example 2:

Input: N = 2
Matrix = {{2, 2},
          {2, 2}}
Output: 4
Explaination: No matter which path is 
chosen, the output is 4.

Your Task:
You do not need to read input or print anything. Your task is to complete the function maximumPath() which takes the size N and the Matrix as input parameters and returns the highest maximum path sum.


Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(N*N)


Constraints:
1 ≤ N ≤ 500
1 ≤ Matrix[i][j] ≤ 1000


class Solution{
    static int maximumPath(int n, int matrix[][])
    {
        // code here
        if (matrix == null || n == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        for (int i=n-1; i>=0; i--) {
            for (int j=0; j<n; j++) {
                int b = (i == n - 1) ? 0 : matrix[i + 1][j];
                int bLeft = (i == n - 1 || j == 0) ? 0 : matrix[i + 1][j - 1];
                int bRight = (i == n - 1 || j == n - 1) ? 0 : matrix[i + 1][j + 1];
                matrix[i][j] += Math.max(b, Math.max(bLeft, bRight));
            }
        }
        for (int i=0; i<n; i++) {
            result = Math.max(result, matrix[0][i]);
        }
        return result;
    }
}