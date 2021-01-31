In Geekland there is a grid of coins of size N x N. You have to find the maximum sum of coins in any sub-grid of size K x K.
Note: Coins of the negative denomination are also possible at Geekland.

Example 1:

Input: N = 5, K = 3 
mat[[]] = {1, 1, 1, 1, 1} 
          {2, 2, 2, 2, 2} 
          {3, 8, 6, 7, 3} 
          {4, 4, 4, 4, 4} 
          {5, 5, 5, 5, 5}
Output: 48
Explanation: {8, 6, 7}
             {4, 4, 4}
             {5, 5, 5}
has the maximum sum

Example 2:

Input: N = 1, K = 1
mat[[]] = {{4}} 
Output: 4
Your Task:  
You don't need to read input or print anything. Complete the function Maximum_Sum() which takes the matrix mat[], size of Matrix N, and value K as input parameters and returns the maximum sum.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N2)

Constraints:
1 ≤ K ≤ N ≤ 103
-5*105 ≤ mat[i][j] ≤ 5*105



class Point {
    int first;
    int second;
    public Point(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution
{
    public int Maximum_Sum(int mat[][],int N,int k){
        // Your code goes here
        // preprocess sum
        Point p = null;
        int row = mat.length;
        int col = mat[0].length;
        int [][] sum = new int [row][col];
        sum[0][0] = mat[0][0];
        // preprocess first row
        for (int j=1; j<col; j++) {
            sum[0][j] = mat[0][j] + sum[0][j-1];
        }
        // preprocess first col
        for (int i=1; i<row; i++) {
            sum[i][0] = mat[i][0] + sum[i-1][0];
        }
        // preprocess the rest matrix
        for (int i=1; i<row; i++) {
            for (int j=1; j<col; j++) {
                sum[i][j] = mat[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }
        int total = 0;
        int max = Integer.MIN_VALUE;
        for (int i=k-1; i<row; i++) {
            for (int j=k-1; j<col; j++) {
                total = sum[i][j];
                if (i - k >= 0) {
                    total -= sum[i-k][j];
                }
                if (j - k >= 0) {
                    total -= sum[i][j-k];
                }
                if (i-k >= 0 && j-k >= 0) {
                    total += sum[i-k][j-k];
                }
                if (total > max) {
                    max = total;
                    p = new Point(i, j);
                }
            }
        }
        int finalSum = 0;
        for (int i=0; i<k; i++) {
            for (int j=0; j<k; j++) {
                int currentRow = i + p.first - k + 1;
                int currentCol = j + p.second - k + 1;
                finalSum += mat[currentRow][currentCol];
            }
        }
        return finalSum;
    }
}
