Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.


class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // bfs
        if (mat == null || mat.length == 0)
            return new int [][]{};
        int row = mat.length;
        int col = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (mat[i][j] == 0)
                    queue.offer(new int []{i, j});
                else
                    mat[i][j] = Integer.MAX_VALUE;
            }
        }
        int [][] directions = new int [][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        bfs(mat, queue, directions, row, col);
        return mat;
    }
    
    public void bfs(int [][] mat, Queue<int[]> queue, int [][] directions, int row, int col) {
        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int [] dir : directions) {
                int newX = dir[0] + x;
                int newY = dir[1] + y;
                if (newX < 0 || newY < 0 || newX >= row || newY >= col || mat[newX][newY] <= mat[x][y] + 1)
                    continue;
                queue.offer(new int []{newX, newY});
                mat[newX][newY] = mat[x][y] + 1;
            }
        }
    }
}


// dynamic programming

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0)
            return new int [][]{};
        int row = mat.length;
        int col = mat[0].length;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (mat[i][j] == 1) {
                    if (i > 0 && j > 0) {
                        mat[i][j] = Math.min(mat[i - 1][j], mat[i][j - 1]) + 1;
                    }
                    else if (i > 0) {
                        mat[i][j] = mat[i - 1][j] + 1;
                    }
                    else if (j > 0) {
                        mat[i][j] = mat[i][j - 1] + 1;
                    }
                    else {
                        mat[i][j] = row + col;
                    }
                }
            }
        }
        for (int i=row-1; i>=0; i--) {
            for (int j=col-1; j>=0; j--) {
                if (mat[i][j] > 1) {
                    if (i < row - 1) {
                        mat[i][j] = Math.min(mat[i][j], mat[i + 1][j] + 1);
                    }
                    if (j < col - 1) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][j + 1] + 1);
                    }
                }
            }
        }
        return mat;
    }
}