Given a matrix of size n*m. Every cell of matrix contains either 'A' or 'B'. Exchange is defined as swaping the characters between two cells. Your task is to find the minimum number of exchange needed to rearrange the given matrix such that no adjacent cell contains the same characters.
Two cells are adjacent if they share one of their common sides (left,right,front or back if exists). 
 

Example 1:

Input: matrix = {{A,A,B,A},{B,A,B,A},{B,B,A,B}}
Output: 4
Explanation: Minimum number of students whose 
sets got changed are 4 (indexes: ((0,1),(0,2),
(0,3),(2,0))). The final alloted sets are:
A B A B
B A B A
A B A B
Example 2:

Input: matrix = {{A,B},{B,A}}
Output: 0
Explanation: No two adjacent cell contains same
character.
 

Your Task:
You don' t need to read or print anything. Your task is to complete the function MinimumExchange() which takes matrix as input parameter and returns minimum number of  exchange needed.
 

Expected Time Complexity: O(n*m)
Expected Space Compelxity: O(1)
 

Constraints:
1 <= n, m <= 100






class Solution
{
    public int MinimumExchange(char[][] matrix)
    {
        // Code here
        int row = matrix.length;
        int col = matrix[0].length;
        char [][] comb1 = new char[row][col];
        char [][] comb2 = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i + j) % 2 == 0) {
                    comb1[i][j] = 'A';
                }
                else {
                    comb1[i][j] = 'B';
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i + j) % 2 == 0) {
                    comb2[i][j] = 'B';
                }
                else {
                    comb2[i][j] = 'A';
                }
            }
        }
        int change1 = 0;
        int change2 = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] != comb1[i][j]) {
                    change1++;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] != comb2[i][j]) {
                    change2++;
                }
            }
        }
        return Math.min(change1, change2);
    }
}