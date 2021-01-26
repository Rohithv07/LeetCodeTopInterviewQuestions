class Solution {
    public int minimumEffortPath(int[][] heights) {
        // we can go with the djikstra here as we need to find the shortest path and take the difference as the weight between two node
        int row = heights.length;
        int col = heights[0].length;
        int [][] directions = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int [][] distance = new int [row][col];
        for (int i=0; i<row; i++)
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        PriorityQueue<int []> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.add(new int []{0, 0, 0});
        // 0th index is distance, 1st index is rowth, 2nd index ins colmth
        while (!minHeap.isEmpty()) {
            int [] topOfQueue = minHeap.remove();
            int dist = topOfQueue[0];
            int x = topOfQueue[1];
            int y = topOfQueue[2];
            if (dist > distance[x][y])
                continue;
            if (x == row - 1 && y == col - 1)
                return dist;
            for (int [] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX < 0 || newY < 0 || newX >= row || newY >= col)
                    continue;
                int effort = Math.max(dist, Math.abs(heights[newX][newY] - heights[x][y]));
                if (distance[newX][newY] > effort) {
                    distance[newX][newY] = effort;
                    minHeap.add(new int []{distance[newX][newY], newX, newY});
                }
            }
        }
        return -1; // this is unreachabel code
    }
}
