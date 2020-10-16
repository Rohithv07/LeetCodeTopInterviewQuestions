Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
Output: false
Example 3:

Input: matrix = [], target = 0
Output: false


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // lets start by brute force
        if (matrix.length == 0)
            return false;
        int row = matrix.length; 
        int col = matrix[0].length;
        // since it is sorted the maximum will be in the last row last col and the min element will be in the first row first col
        if (target > matrix[row-1][col-1] || target < matrix[0][0])
            return false;
        // O(mn)
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] == target)
                    return true;
            }
        }
        return false;
        
        
        // since its searching in a matrix, we can make use of binary search.
        if (matrix.length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid/col][mid%col] == target)
                return true;
            else if (matrix[mid/col][mid%col] < target)
                left = mid + 1;
            else 
                right = mid - 1;
        }
        return false;
        // O(log(row) + log(col))
    }
}



