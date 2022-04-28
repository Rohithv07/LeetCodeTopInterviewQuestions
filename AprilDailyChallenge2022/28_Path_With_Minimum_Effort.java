You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

 

Example 1:



Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
Example 2:



Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
Example 3:


Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.
 

Constraints:

rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106


class Solution {
    
    private final int [][] directions = new int [][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int [][] distance = new int [row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a1, a2) -> Integer.compare(a1[0], a2[0]));
        minHeap.offer(new int [] {0, 0, 0});
        while (!minHeap.isEmpty()) {
            int [] top = minHeap.poll();
            int effort = top[0];
            int x = top[1];
            int y = top[2];
            if (effort > distance[x][y]) {
                continue;
            }
            if (x == row - 1 && y == col - 1) {
                return effort;
            }
            for (int [] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (!isValid(newX, newY, row, col)) {
                    continue;
                }
                int currentEffort = Math.max(effort, Math.abs(heights[newX][newY] - heights[x][y]));
                if (distance[newX][newY] > currentEffort) {
                    distance[newX][newY] = currentEffort;
                    minHeap.offer(new int [] {distance[newX][newY], newX, newY});
                }
            }
        }
        return -1;
    }
    
    private boolean isValid(int i, int j, int row, int col) {
        return i >= 0 && j >= 0 && i < row && j < col;
    }
}