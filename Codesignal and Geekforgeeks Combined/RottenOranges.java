// https://practice.geeksforgeeks.org/contest/interview-series-49/problems/

class Solution
{
    //Function to find minimum time required to rot all oranges. 
    
    private int [][] direction = new int [][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int time = 0;
        int fresh = 0;
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                else if (grid[i][j] == 2) {
                    queue.offer(new int []{i, j});
                }
            }
        }
        while (!queue.isEmpty() && fresh > 0) {
            time++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int [] top = queue.poll();
                int x = top[0];
                int y = top[1];
                for (int [] dir : direction) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX < 0 || newY < 0 || newX >= row || newY >= col || grid[newX][newY] != 1) {
                        continue;
                    }
                    fresh--;
                    queue.offer(new int []{newX, newY});
                    grid[newX][newY] = 2;
                }
            }
        }
        return fresh > 0 ? -1 : time;
    }
}