Spiderman is stuck in a difficult situation. His arch-enemy the Green Goblin has planted several of his infamous Pumpkin Bombs in various locations in a building. Help Spiderman activate his Spidey Sense and identify the impact zones. 
He has a blueprint of the building which is a M x N matrix that is filled with the characters ‘O’, ‘B’, and ‘W’ where: 
‘O’ represents an open space.
‘B’ represents a bomb.
‘W’ represents a wall.
You have to replace all of the O’s (open spaces) in the matrix with their shortest distance from a bomb without being able to go through any walls. Also, replace the bombs with 0 and walls with -1 in the resultant matrix. If no path exists between a bomb and an open space replace the corresponding 'O' with -1.

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




class Solution
{
    public static int[][] findDistance(char mat[][], int m,int n)
    {
        int [][] result = new int [m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (mat[i][j] == 'B') {
                    result[i][j] = 0;
                }
                else if (mat[i][j] == 'W') {
                    result[i][j] = -1;
                }
                else {
                    result[i][j] = 1;
                }
            }
        }
        Queue<int []> queue = new LinkedList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (result[i][j] == 0) {
                    queue.add(new int [] {i, j});
                }
                else if (result[i][j] == 1){
                    result[i][j] = Integer.MAX_VALUE;
                }
                else {
                    continue;
                }
            }
        }
        int [][] directions = new int [][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int [] dir : directions) {
                int newX = dir[0] + x;
                int newY = dir[1] + y;
                if (newX < 0 || newY < 0 || newX >= m || newY >= n || result[newX][newY] == -1 || result[newX][newY] <= result[x][y] + 1)
                    continue;
                queue.add(new int [] {newX, newY});
                result[newX][newY] = result[x][y] + 1;
            }
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (result[i][j] == Integer.MAX_VALUE)
                    result[i][j] = -1;
            }
        }
        return result;
        
    }
}

