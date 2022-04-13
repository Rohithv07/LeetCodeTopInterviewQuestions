Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20




class Solution {
    public int[][] generateMatrix(int n) {
        int [][] matrix = new int [n][n];
        int left = 0;
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int count = 1;
        while (left <= right) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = count++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = count++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = count++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = count++;
            }
            left++;
        }
        return matrix;
    }
}