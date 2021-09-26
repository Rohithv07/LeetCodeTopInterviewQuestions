You are given an n x n binary grid board. In each move, you can swap any two rows with each other, or any two columns with each other.

Return the minimum number of moves to transform the board into a chessboard board. If the task is impossible, return -1.

A chessboard board is a board where no 0's and no 1's are 4-directionally adjacent.

 

Example 1:


Input: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
Output: 2
Explanation: One potential sequence of moves is shown.
The first move swaps the first and second column.
The second move swaps the second and third row.
Example 2:


Input: board = [[0,1],[1,0]]
Output: 0
Explanation: Also note that the board with 0 in the top left corner, is also a valid chessboard.
Example 3:


Input: board = [[1,0],[1,0]]
Output: -1
Explanation: No matter what sequence of moves you make, you cannot end with a valid chessboard.
 

Constraints:

n == board.length
n == board[i].length
2 <= n <= 30
board[i][j] is either 0 or 1.


class Solution {
    public int movesToChessboard(int[][] board) {
        if (board == null || board.length == 0) {
            return -1;
        }
        int row = board.length;
        int col = board[0].length;
        int rowToMove = 0;
        int colToMove = 0;
        int rowOneCount = 0;
        int colOneCount = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if ((board[0][0] ^ board[i][0] ^ board[i][j] ^ board[0][j]) == 1) {
                    return -1;
                }
            }
        }
        for (int i=0; i<row; i++) {
            rowOneCount += board[0][i];
            colOneCount += board[i][0];
            if (board[i][0] == i % 2) {
                rowToMove += 1;
            }
            if (board[0][i] == i % 2) {
                colToMove += 1;
            }
        }
        if (rowOneCount < row / 2 || rowOneCount > (row + 1) / 2) {
            return -1;
        }
        if (colOneCount < row / 2 || colOneCount > (col + 1) / 2) {
            return -1;
        }
        if (row % 2 == 1) {
            if (colToMove % 2 != 0) {
                colToMove = col - colToMove;
            }
            if (rowToMove % 2 != 0) {
                rowToMove = row - rowToMove;
            }
        }
        else {
            colToMove = Math.min(colToMove, col - colToMove);
            rowToMove = Math.min(rowToMove, row - rowToMove);
        }
        return (rowToMove + colToMove) / 2;
    }
}