Spiderman is stuck in a difficult situation. His arch-enemy the Green Goblin has planted several of his infamous Pumpkin Bombs in various locations in a building. Help Spiderman activate his Spidey Sense and identify the impact zones. 
He has a blueprint of the building which is a M x N matrix that is filled with the characters O, B, and W where: 
O represents an open space.
B represents a bomb.
W represents a wall.
You have to replace all of the Os (open spaces) in the matrix with their shortest distance from a bomb without being able to go through any walls. Also, replace the bombs with 0 and walls with -1 in the resultant matrix. If no path exists between a bomb and an open space replace the corresponding 'O' with -1.

Example 1:

Input: N = 3, M = 3
A[] = {{O, O, O}, 
       {W, B, B}, 
       {W, O, O}}
Output: {{2, 1, 1}, 
         {-1, 0, 0},  
         {-1, 1, 1}}
Explanation: The walls at (1,0) and (2,0) 
are replaced by -1. The bombs at (1,1) and 
(1,2) are replaced by 0. The impact zone 
for the bomb at (1,1) includes open spaces 
at index (0,0), (0,1) and (2,1) with distance 
from bomb calculated as 2,1,1 respectively.
The impact zone for the bomb at (1,2) 
includes open spaces at index (0,3) and (2,2) 
with distance from bomb calculated as 1,1 
respectively.

Example 2:

IInput: N = 2, M = 2
A[] = {{O, O},
       {O, O}} 
Output: {{-1, -1}
         {-1, -1}
Your Task:  
You don't need to read input or print anything. Complete the function findDistance() which takes the matrix A[], M, and N as input parameters and the resultant matrix

Expected Time Complexity: O(M*N)
Expected Auxiliary Space: O(M*N)


Constraints:
1 ≤ N*M ≤ 106



class Solution
{
    
    private static final int [][] direction = new int [][]
    {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public static int[][] findDistance(char mat[][], int m,int n)
    {
        // Your code goes here
        if (mat == null || m == 0) {
            return new int [][]{};
        }
        int [][] result = new int [m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(result[i], Integer.MAX_VALUE);
        bfs(mat, m, n, result);
        return result;
    }
    
    public static void bfs(char [][] mat, int m, int n, int [][] result) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 'B') {
                    queue.offer(new int []{i, j});
                    result[i][j] = 0;
                }
            }
        }
        if (queue.isEmpty()) {
            for (int i = 0; i < m; i++)
                Arrays.fill(result[i], -1);
            return;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int [] current = queue.poll();
                mat[current[0]][current[1]] = 'P';
                for (int [] dir : direction) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];
                    if (x < 0 || y < 0 || x >= m || y >= n || mat[x][y] != 'O') {
                        continue;
                    }
                    result[x][y] = Math.min(result[x][y], result[current[0]][current[1]] + 1);
                    queue.offer(new int []{x, y});
                }
            }
        }
        extraWorkForResult(result, m, n);
    }
    
    public static void extraWorkForResult(int [][] result, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] == Integer.MAX_VALUE) {
                    result[i][j] = -1;
                }
            }
        }
    }
}