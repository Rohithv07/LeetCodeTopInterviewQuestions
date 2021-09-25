You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.

Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.

 

Example 1:

Input: 
grid = 
[[0,0,0],
 [1,1,0],
 [0,0,0],
 [0,1,1],
 [0,0,0]], 
k = 1
Output: 6
Explanation: 
The shortest path without eliminating any obstacle is 10. 
The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
Example 2:

Input: 
grid = 
[[0,1,1],
 [1,1,1],
 [1,0,0]], 
k = 1
Output: -1
Explanation: 
We need to eliminate at least two obstacles to find such a walk.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 40
1 <= k <= m * n
grid[i][j] == 0 or 1
grid[0][0] == grid[m - 1][n - 1] == 0


class Solution {
    
    private static final int [][] directions = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        if (k >= row + col - 2) {
            return row + col - 2;// manhatten distance
        }
        return bfs(grid, k, row, col);
    }
    
    public int bfs(int [][] grid, int k, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        boolean [][][] visited = new boolean [row][col][k + 1];
        queue.offer(new int []{0, 0, k});
        visited[0][0][k] = true;
        int shortestDistance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int [] current = queue.poll();
                int x = current[0];
                int y = current[1];
                int obstacles = current[2];
                if (x == row - 1 && y == col - 1) {
                    return shortestDistance;
                }
                for (int [] dir : directions) {
                    int newX = dir[0] + x;
                    int newY = dir[1] + y;
                    if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                        continue;
                    }
                    int remainingObstacle = obstacles - grid[newX][newY];
                    if (remainingObstacle >= 0 && !visited[newX][newY][remainingObstacle]) {
                        visited[newX][newY][remainingObstacle] = true;
                        queue.offer(new int []{newX, newY, remainingObstacle});
                    }
                }
            }
            shortestDistance += 1;
        }
        return -1;
    }
}