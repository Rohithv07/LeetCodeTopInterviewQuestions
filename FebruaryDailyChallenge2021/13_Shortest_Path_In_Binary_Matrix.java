In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.

 

Example 1:

Input: [[0,1],[1,0]]


Output: 2

Example 2:

Input: [[0,0,0],[1,1,0],[1,1,0]]


Output: 4

 

Note:

1 <= grid.length == grid[0].length <= 100
grid[r][c] is 0 or 1



class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1)
            return -1;
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int [] {0, 0});
        boolean [][] visited = new boolean[row][col];
        visited[0][0] = true;
        int count = 0;
        int [][] directions = new int [][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int [] current = queue.poll();
                int x = current[0];
                int y = current[1];
                if (x == row -1 && y == col - 1)
                    return count + 1;
                for (int [] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX < 0 || newY < 0 || newX >= row || newY >= col || visited[newX][newY] || grid[newX][newY] == 1)
                        continue;
                    if (!visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.add(new int [] {newX, newY});
                    }
                }
            }
            count += 1;
        }
        return -1;
    }
}
