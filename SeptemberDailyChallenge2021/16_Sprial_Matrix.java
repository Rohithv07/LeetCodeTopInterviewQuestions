Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int lowRow = 0;
        int lowCol = 0;
        int highCol = col - 1;
        int highRow = row - 1;
        List<Integer> result = new ArrayList<>();
        while (lowRow <= highRow && lowCol <= highCol) {
            for (int i=lowRow; i<=highCol; i++) {
                result.add(matrix[lowRow][i]);
            }
            lowRow++;
            for (int i=lowRow; i<=highRow; i++) {
                result.add(matrix[i][highCol]);
            }
            highCol--;
            if (lowRow <= highRow) {
                for (int i=highCol; i>=lowCol; i--) {
                    result.add(matrix[highRow][i]);
                }
                highRow--;
            }
            if (lowCol <= highCol) {
                for (int i=highRow; i>=lowRow; i--) {
                    result.add(matrix[i][lowCol]);
                }
                lowCol++;
            }
        }
        return result;
    }
}