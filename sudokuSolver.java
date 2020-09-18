Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.




Solution:

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
