Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = []
Output: 0
Example 3:

Input: matrix = [["0"]]
Output: 0
Example 4:

Input: matrix = [["1"]]
Output: 1
Example 5:

Input: matrix = [["0","0"]]
Output: 0
 

Constraints:

rows == matrix.length
cols == matrix[i].length
0 <= row, cols <= 200
matrix[i][j] is '0' or '1'.


class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int [][] dp = new int [row][col];
        int maxRect = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                }
                else {
                    if (matrix[i][j] == '1')
                        dp[i][j] = dp[i - 1][j] + matrix[i][j] - '0';
                }
            }
        }
        for (int [] eachRow : dp) {
            maxRect = Math.max(maxRect, histogram(eachRow));
        }
        return maxRect;
    }
    
    public int histogram(int [] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int length = height.length;
        int [] left = new int [length];
        int [] right = new int [length];
        int result = 0;
        left[0] = -1;
        right[length - 1] = length;
        for (int i=1; i<length; i++) {
            int index = i - 1;
            while (index >= 0 && height[index] >= height[i]) {
                index = left[index];
            }
            left[i] = index;
        }
        for (int i=length-2; i>=0; i--) {
            int index = i + 1;
            while (index < length && height[index] >= height[i]) {
                index = right[index];
            }
            right[i] = index;
        }
        for (int i=0; i<length; i++) {
            result = Math.max(result, height[i] * (right[i] - left[i] - 1));
        }
        return result;
    }
}