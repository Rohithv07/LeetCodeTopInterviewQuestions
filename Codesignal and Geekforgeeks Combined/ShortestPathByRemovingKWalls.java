Given a 2-D binary matrix of size n*m, where 0 represents an empty space while 1 represents a wall you cannot walk through. You are also given an integer k.
You can walk up, down, left, or right. Given that you can remove up to k walls, return the minimum number of steps to walk from the top left corner (0, 0) to the bottom right corner (n-1, m-1).
Note: If there is no way to walk from the top left corner to the bottom right corner, return -1.


Example 1:

Input: n = 3, m = 3, k = 1
mat = {{0, 0, 0},
       {0, 0, 1},
       {0, 1, 0}}
Output:
4
Explanation:
We can remove any one of the walls and
reach the bottom in 4 moves.  
Example 2:

Input:
n = 2, m = 2, k = 0
mat[] = {{0, 1},
         {1, 0}}
Output:
-1
Explanation:
There's no way of reaching the bottom
corner without removing any walls.

Your Task:
The task is to complete the function shotestPath() which takes three integers n, m, and k and also a matrix of size n*m as input and returns the minimum number of steps to walk from the top left corner to the bottom right corner.


Constraints:
1 ≤ n,m ≤ 50
0 ≤ k ≤ n*m
Top left and bottom right corners doesn't have 1


Expected Time Complexity: O(n*m*k).
Expected Auxiliary Space: O(n*m*k).


//User function Template for Java

class Solution {
    static int shotestPath(int[][] mat, int n, int m, int k) {
        // code here
        if (mat[0][0] == 1) {
            return -1;
        }
        if (mat[n - 1][m - 1] == 1) {
            return -1;
        }
        if (n == 1 && m == 1) {
            return 0;
        }
        return bfs(mat, n, m, k);
    }
    
    static int bfs(int [][] mat, int n, int m, int k) {
        final int [][] directions = new int [][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        Queue<Node> queue = new LinkedList<>();
        boolean [][][] visited = new boolean [n][m][n * m];
        queue.offer(new Node (0, 0, 0, 0));
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node top = queue.poll();
                int currentRow = top.row;
                int currentCol = top.col;
                int currentWallsRemaining = top.wall;
                int currentDistance = top.distance;
                if (currentRow == n - 1 && currentCol == m - 1) {
                    return currentDistance;
                }
                for (int [] dir : directions) {
                    int nextRow = currentRow + dir[0];
                    int nextCol = currentCol + dir[1];
                    if (isSafe(nextRow, nextCol, n, m)) {
                        int newRemoved = currentWallsRemaining + mat[nextRow][nextCol];
                        if (k >= newRemoved && !visited[nextRow][nextCol][newRemoved]) {
                            visited[nextRow][nextCol][newRemoved] = true;
                            queue.offer(new Node(nextRow, nextCol, newRemoved, currentDistance + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    static boolean isSafe(int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col) {
            return false;
        }
        return true;
    }
}

class Node {
    int row;
    int col;
    int wall;
    int distance;
    
    public Node(int row, int col, int wall, int distance) {
        this.row = row;
        this.col = col;
        this.wall = wall;
        this.distance = distance;
    }
}