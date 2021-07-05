In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.

You are given an m x n matrix mat and two integers r and c representing the row number and column number of the wanted reshaped matrix.

The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

 

Example 1:


Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]
Example 2:


Input: mat = [[1,2],[3,4]], r = 2, c = 4
Output: [[1,2],[3,4]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 100
-1000 <= mat[i][j] <= 1000
1 <= r, c <= 300

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat == null || mat.length == 0)
            return new int [][] {};
        int row = mat.length;
        int col = mat[0].length;
        if (row * col != r * c) {
            return mat;
        }
        int [][] result = new int [r][c];
        int currentResultRow = 0;
        int currentResultCol = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (currentResultCol >= c) {
                    currentResultRow += 1;
                    currentResultCol = 0;
                    result[currentResultRow][currentResultCol] = mat[i][j];
                }
                else {
                    result[currentResultRow][currentResultCol] = mat[i][j];
                }
                currentResultCol++;
            }
        }
        return result;
    }
}

/*
Another approach

public int[][] matrixReshape(int[][] nums, int r, int c) {
    int n = nums.length, m = nums[0].length;
    if (r*c != n*m) return nums;
    int[][] res = new int[r][c];
    for (int i=0;i<r*c;i++) 
        res[i/c][i%c] = nums[i/m][i%m];
    return res;
}
*/
