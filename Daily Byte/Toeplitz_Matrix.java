Given a two-dimensional integer array, matrix, return whether or not the matrix is a Toeplitz matrix.
Note: A Toeplitz matrix is a matrix in which every diagonal from the top-left corner to the bottom-right hand corner of the matrix contains the same element.

Ex: Given the following matrix…

matrix = [
  [1, 2, 3],
  [4, 1, 2],
  [5, 4, 1]
], return true ([4, 4], [1, 1, 1], and [2, 2] are the diagonals and each diagonal has the same element).
Ex: Given the following matrix…

matrix = [
  [1, 2],
  [3, 4]
], return false.


class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i=0; i<row-1; i++) {
            for (int j=0; j<col-1; j++) {
                if (matrix[i][j] != matrix[i+1][j+1])
                    return false;
            }
        }
        return true;
    }
}

