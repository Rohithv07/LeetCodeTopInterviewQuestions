The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9


class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char [][] board = new char [n][n];
        for (char [] b : board) {
            Arrays.fill(b, '.');
        }
        backtrack(board, n, result, 0);
        return result;
    }
    
    public void backtrack(char [][] board, int n, List<List<String>> result, int position) {
        if (position >= n) {
            List<String> currentConfig = new ArrayList<>();
            for (char [] b : board) {
                currentConfig.add(new String(b));
            }
            result.add(currentConfig);
            return;
        }
        for (int i=0; i<n; i++) {
            if (isPossibleToPlaceQueen(board, i, position, n)) {
                board[i][position] = 'Q';
                backtrack(board, n, result, position + 1);
                board[i][position] = '.';
            }
        }
    }
    
    public boolean isPossibleToPlaceQueen(char [][] board, int row, int col, int n) {
        int storeRow = row;
        int storeCol = col;
        while (storeRow >= 0 && storeCol >= 0) {
            if (board[storeRow][storeCol] == 'Q') {
                return false;
            }
            storeRow--;
            storeCol--;
        }
        storeRow = row;
        storeCol = col;
        while (storeCol >= 0) {
            if (board[storeRow][storeCol] == 'Q') {
                return false;
            }
            storeCol--;
        }
        storeCol = col;
        while (storeRow < n && storeCol >= 0) {
            if (board[storeRow][storeCol] == 'Q') {
                return false;
            }
            storeCol--;
            storeRow++;
        }
        return true;
    }
}