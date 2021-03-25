Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:

The order of returned grid coordinates does not matter.
Both m and n are less than 150.
 

Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).



class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        int row = matrix.length;
        if (row == 0)
            return result;
        int col = matrix[0].length;
        boolean [][] pacific = new boolean [row][col];
        boolean [][] atlantic = new boolean [row][col];
        // top bottom
        for (int i=0; i<col; i++) {
            dfs(matrix, 0, i, matrix[0][i], pacific);
            dfs(matrix, row-1, i, matrix[row-1][i], atlantic);
        }
        // left right
        for (int i=0; i<row; i++) {
            dfs(matrix, i, 0, matrix[i][0], pacific);
            dfs(matrix, i, col-1, matrix[i][col-1], atlantic);
        }
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> currentResult = new ArrayList<>();
                    currentResult.add(i);
                    currentResult.add(j);
                    result.add(currentResult);
                }
            }
        }
        return result;
    }
    
    public void dfs(int [][] matrix, int i, int j, int preHeight, boolean [][] ocean) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || preHeight > matrix[i][j] || ocean[i][j])
            return;
        ocean[i][j] = true;
        dfs(matrix, i+1, j, matrix[i][j], ocean);
        dfs(matrix, i-1, j, matrix[i][j], ocean);
        dfs(matrix, i, j+1, matrix[i][j], ocean);
        dfs(matrix, i, j-1, matrix[i][j], ocean);
    }
}
