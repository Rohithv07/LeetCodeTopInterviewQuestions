class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || word.length() == 0)
            return false;
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (word.charAt(0) == board[i][j] &&
                   dfsHelper(board, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }
    public boolean dfsHelper(char [][] board, int row, int col, int count, String word) {
        if (count == word.length())
            return true;
        if (row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col] != word.charAt(count))
            return false;
        char temp = board[row][col];
        board[row][col] = ' ';
        boolean test = dfsHelper(board, row+1, col, count+1, word) ||
            dfsHelper(board, row-1, col, count+1, word) ||
            dfsHelper(board, row, col+1, count+1, word) ||
            dfsHelper(board, row, col-1, count+1, word);
        board[row][col] = temp;
        return test;
    }
}
