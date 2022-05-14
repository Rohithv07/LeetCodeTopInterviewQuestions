In the game of Broken Blocks, the player is allowed to move on m x n blocks i.e. m levels and n stone blocks on each level such that one level is vertically above the previous level (as in a staircase), with some of its stone blocks replaced by wooden blocks.
The player at the start of the game is present on the ground level (which should be considered as level 0 or it can be considered as level -1). The player can start from any of the blocks present on the level 0 and start moving further to next levels. The player can only move to the stone-block just above to the present stone-block or diagonally to the left or to the right. The player cant move on the same level.
If the player steps on any of the wooden block (denoted by -1), he will fall off the board and die as the wood-block will not able to hold players weight. Each of the stone-block has some gold coins present on it (wooden blocks doesnt have any coins on them). If at any point the player cant move to further level due to any reason, the game ends and his present total coin score will be considered.
The players aim is to collect as many gold coins as he can without falling off the board.
 

Example 1:

Input: matrix = {{2,5,6},{-1,3,2},{4,-1,5}}
Output: 14
Explanation: Assume 0-based indexing.The matrix 
is:
2 5 6 (level 0)
-1 3 2 (level 1)
4 -1 5 (lever 2)
The player can collect maximum number of coins 
by moving through:matrix[0][2] + matrix[1][1] 
+ matrix[2][2] = 6 + 3 + 5 = 14 coins.
Example 2:

Input: matrix = {{-1,2,3,4},{5,-1,-1,2},
{4,3,-1,-1}}
Output: 11
Explanation: The matrix is:
-1 2 3 4(level 0)
5 -1 -1 2(level 1)
4 3 -1 1(level 2)
The player can collect maximum number of coins 
by moving through:a[0][1] + a[1][0] + a[2][0] 
= 2 + 5 + 4 = 11 coins.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function MaxGold() which takes matrix as input parameter and returns the maximum number of gold coins.
 

Expected Time Complexity: O(n*m)
Expected Space Complexity: O(1)



//User function Template for Java

class Solution
{
    public int MaxGold(int[][] matrix)
    {
        // Code here
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        for (int i = row - 2; i >=0 ; i--) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == -1) {
                    continue;
                }
                matrix[i][j] += Math.max(j > 0 ? matrix[i + 1][j - 1] : 0,
                Math.max(matrix[i + 1][j], Math.max(j + 1 < col ? matrix[i + 1][j + 1] : 0, 0)));
            }
        }
        for (int i = 0; i < col; i++) {
            max = Math.max(max, matrix[0][i]);
        }
        return max;
    }
}