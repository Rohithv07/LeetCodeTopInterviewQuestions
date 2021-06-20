On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).

Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.

You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?

Example 1:

Input: [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.

You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
Example 2:

Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation:
 0  1  2  3  4
24 23 22 21  5
12 13 14 15 16
11 17 18 19 20
10  9  8  7  6

The final route is marked in bold.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
Note:

2 <= N <= 50.
grid[i][j] is a permutation of [0, ..., N*N - 1].

// dijkstra + binary search is most optimal 
// here time is O(V + E log V)
class Solution {
    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0)
            return -1;
        PriorityQueue<int []> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(grid[a[0]][a[1]], grid[b[0]][b[1]]));
        int row = grid.length;
        int col = grid[0].length;
        int [][] directions = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean [][] visited = new boolean [row][col];
        return bfsDijkstras(minHeap, row, col, directions, grid, visited);
    }
    
    public int bfsDijkstras(PriorityQueue<int[]> minHeap, int row, int col, int [][] directions, int [][] grid, boolean [][] visited) {
        int time = 0;
        minHeap.offer(new int [] {0, 0});
        while (!minHeap.isEmpty()) {
            int [] current = minHeap.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            time = Math.max(time, grid[currentRow][currentCol]);
            if (currentRow == row - 1 && currentCol == col - 1) {
                return time;
            }
            for (int [] dir : directions) {
                int nextRow = dir[0] + currentRow;
                int nextCol = dir[1] + currentCol;
                if (nextCol < 0 || nextRow < 0 || nextRow >= row || nextCol >= col || visited[nextRow][nextCol])
                    continue;
                visited[currentRow][currentCol] = true;
                minHeap.offer(new int [] {nextRow, nextCol});
            }
        }
        return -1;
    }
}
