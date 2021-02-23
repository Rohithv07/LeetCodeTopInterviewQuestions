Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 

Example 1:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
Example 2:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matix[i][j] <= 109
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-109 <= target <= 109



class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // int row = matrix.length;
        // int col = matrix[0].length;
        // for (int i=0; i<row; i++) {
        //     for (int j=0; j<col; j++) {
        //         if (matrix[i][j] == target)
        //             return true;
        //     }
        // }
        // return false; // O(mn)
        
        // from the current position, if the value < target, then one row can be skipped
        // if the value > target, then col can be skipped
        // all these happens because they are sorted
        
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            if (matrix[row][col] < target)
                row += 1;
            else
                col -= 1;
        }
        return false;
        
        // O(m + n)
    }
}
