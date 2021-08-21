Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

 

Example 1:


Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:


 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.



class Solution {
    private final char EMPTY = '.';
    public void solveSudoku(char[][] board) {
        canSolve(board, 0, 0);
    }
    public boolean canSolve(char [][] board, int row, int col) {
        // check our position
        if (col == board[row].length) {
            col = 0;
            row += 1;
            if (row == board.length)
                return true;
        }
        // check whether we are at empty cell
        if (board[row][col] != EMPTY)
            return canSolve(board, row, col+1);
        
        // look for various place to fill the ceel
        for (int val=1; val<=board.length; val++) {
            char possible = (char) (val + '0');
            if (canPlace(board, row, col, possible)) {
                board[row][col] = possible;
                if (canSolve(board, row, col+1))
                    return true;
                board[row][col] = EMPTY;
            }
        }
        return false;
    }
    public boolean canPlace(char [][] board, int row, int col, char possible) {
        // column placement
        for (char [] placement: board) {
            if (possible == placement[col])
                return false;
        }
        // row placement
        for (int i=0; i<board[row].length; i++) {
            if (possible == board[row][i])
                return false;
        }
        // computing the subbox size
        int regionSize = (int) Math.sqrt(board.length);
        int vertical = row / regionSize;
        int horizontal = col / regionSize;
        int topLeftSubRow = regionSize * vertical;
        int topLeftSubCol = regionSize * horizontal;
        
        // now check in the subboxes
        for (int i=0; i<regionSize; i++) {
            for (int j=0; j<regionSize; j++) {
                if (possible == board[topLeftSubRow+i][topLeftSubCol+j])
                    return false;
            }
        }
        return true;
    }
}