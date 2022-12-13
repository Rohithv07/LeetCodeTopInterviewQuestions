Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

 

Example 1:


Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
Example 2:


Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100



class Solution {
    public int minFallingPathSum(int[][] A) {
  int rows = A.length;
  int cols = A[0].length;
  // DP matrix has 2 extra columns
  int[][] dp = new int[rows][cols + 2];
  // Fill the first row of DP matrix
  for (int i = 1; i <= cols; i++) {
    dp[0][i] = A[0][i - 1];
  }
  // Fill Integer.MAX_VALUE into first and last column of DP matrix
  for (int i = 0; i < rows; i++) {
    dp[i][0] = Integer.MAX_VALUE;
    dp[i][cols + 1] = Integer.MAX_VALUE;
  }
  // Building the DP matrix
  for (int i = 1; i < rows; i++) {
    for (int j = 1; j <= cols; j++) {
      // Find the minimum neighbor from previous row in DP matrix
      int minNeighbor = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
      minNeighbor = Math.min(minNeighbor, dp[i - 1][j + 1]);
      dp[i][j] = A[i][j - 1] + minNeighbor;
    }
  }
  // The minimum path sum is minimum of the last row in DP matrix
  int min = Integer.MAX_VALUE;
  for (int i = 1; i <= cols; i++) {
    min = Math.min(min, dp[rows - 1][i]);
  }
  return min;
}
}