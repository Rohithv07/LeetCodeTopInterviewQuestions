Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?



// O(m + n) space

class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean [] checkRow = new boolean [row];
        boolean [] checkCol = new boolean [col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] == 0) {
                    checkRow[i] = true;
                    checkCol[j] = true;
                }
            }
        }
        for (int i=0; i<row; i++) {
            if (checkRow[i]) {
                for (int j=0; j<col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j=0; j<col; j++) {
            if (checkCol[j]) {
                for (int i=0; i<row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}


// constant space

class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean checkRow = false;
        boolean checkCol = false;
        // first check for first row and then for first col
        for (int i=0; i<col; i++) {
            if (matrix[0][i] == 0) {
                checkRow = true;
                break;
            }
        }
        for (int i=0; i<row; i++) {
            if (matrix[i][0] == 0) {
                checkCol = true;
                break;
            }
        }
        for (int i=1; i<row; i++) {
            for (int j=1; j<col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i=1; i<row; i++) {
            for (int j=1; j<col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (checkRow) {
            for (int i=0; i<col; i++) {
                matrix[0][i] = 0;
            }
        }
        if (checkCol) {
            for (int i=0; i<row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}