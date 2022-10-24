// https://practice.geeksforgeeks.org/contest/weekly-interview-series-72/problems/#


//User function Template for Java
class Solution
{
    
    private final int [][] direction = new int [][]{{0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    
    public int[][] chefAndWells(int n,int m,char c[][])
    {
        // store the location of well in the queue
        int [][] result = new int [n][m];
        boolean [][] visited = new boolean [n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (c[i][j] == 'W') {
                    result[i][j] = 0;
                    queue.offer(new int []{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        bfs(queue, result, c, n, m, visited);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j] == 0 && c[i][j] == 'H') {
                    result[i][j] = -1;
                }
                else if (c[i][j] == '.') {
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }
    
    private void bfs(Queue<int[]> queue, int [][] result, char [][] c, int n, int m, boolean [][] visited) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int [] current = queue.poll();
                int row = current[0];
                int col = current[1];
                int currentDistance = current[2];
                for (int [] dir : direction) {
                    int newRow = dir[0] + row;
                    int newCol = dir[1] + col;
                    if (newRow < 0 || newCol < 0 || newRow >= n || newCol >= m || c[newRow][newCol] == 'W' || c[newRow][newCol] == 'N' || visited[newRow][newCol]) {
                        continue;
                    }
                    int newDistance = currentDistance + 2;
                    result[newRow][newCol] = newDistance;
                    visited[newRow][newCol] = true;
                    queue.offer(new int []{newRow, newCol, newDistance});
                }
            }
        }
    }
}