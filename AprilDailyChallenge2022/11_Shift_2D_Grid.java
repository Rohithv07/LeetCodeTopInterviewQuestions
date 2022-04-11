Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:

Element at grid[i][j] moves to grid[i][j + 1].
Element at grid[i][n - 1] moves to grid[i + 1][0].
Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.

 

Example 1:


Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]
Example 2:


Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
Example 3:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
Output: [[1,2,3],[4,5,6],[7,8,9]]
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m <= 50
1 <= n <= 50
-1000 <= grid[i][j] <= 1000
0 <= k <= 100


class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (grid == null || grid.length == 0 || k < 0) {
            return result;
        }
        int row = grid.length;
        int col = grid[0].length;
        k %= (row * col);
        while (k-- > 0) {
            int previous = grid[row - 1][col - 1]; // the very last comes to [0][0]
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int temp = grid[i][j];
                    grid[i][j] = previous;
                    previous = temp;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            List<Integer> rowWise = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                rowWise.add(grid[i][j]);
            }
            result.add(new ArrayList<>(rowWise));
        }
        return result;
    }
}