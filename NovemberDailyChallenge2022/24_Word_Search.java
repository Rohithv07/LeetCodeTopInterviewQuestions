Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board?


class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        char firstChar = word.charAt(0);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (firstChar == board[i][j] && dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char [][] board, int i, int j, String word, int current) {
        if (word.length() == current) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(current)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '.';
        boolean isPossible = dfs(board, i + 1, j, word, current + 1) || 
        dfs(board, i - 1, j, word, current + 1) || 
        dfs(board, i, j + 1, word, current + 1) || 
        dfs(board, i, j - 1, word, current + 1);
        board[i][j] = temp;
        return isPossible;
    }
}