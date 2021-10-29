You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.


class Solution {
    
    private final int [][] direction = new int [][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0;
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1) {
                    fresh += 1;
                }
                else if (grid[i][j] == 2) {
                    queue.offer(new int []{i, j});
                }
            }
        }
        while (!queue.isEmpty() && fresh > 0) {
            time++;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int [] current = queue.poll();
                int x = current[0];
                int y = current[1];
                for (int [] dir : direction) {
                    int newX = dir[0] + x;
                    int newY = dir[1] + y;
                    if (newX < 0 || newY < 0 || newX >= row || newY >= col || grid[newX][newY] != 1) {
                        continue;
                    }
                    grid[newX][newY] = 2;
                    fresh--;
                    queue.offer(new int [] {newX, newY});
                }
            }
        }
        return fresh == 0 ? time : -1;
    }
}