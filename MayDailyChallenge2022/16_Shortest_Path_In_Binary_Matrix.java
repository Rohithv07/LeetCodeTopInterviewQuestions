Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

 

Example 1:


Input: grid = [[0,1],[1,0]]
Output: 2
Example 2:


Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1



class Solution {
    
    private int [][] direction = new int [][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, -1}, {-1, 1}, {1, 1}, {-1, -1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int [] {0, 0});
        grid[0][0] = -1;
        int pathLength = 0;
        while (!queue.isEmpty()) {
            pathLength++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int [] top = queue.poll();
                int x = top[0];
                int y = top[1];
                if (x == row - 1 && y == col - 1) {
                    return pathLength;
                }
                for (int [] dir : direction) {
                    int newX = dir[0] + x;
                    int newY = dir[1] + y;
                    if (newX < 0 || newY < 0 || newX >= row || newY >= col || grid[newX][newY] != 0) {
                        continue;
                    }
                    grid[newX][newY] = -1;
                    queue.offer(new int [] {newX, newY});
                }
            }
        }
        return -1;
    }
}