The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

Example 1:


Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 9





class Solution {
    public int totalNQueens(int n) {
        char [][] board = new char [n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        backtrack(result, n, 0, board);
        System.out.println(result);
        return result.size();
    }
    
    public void backtrack(List<List<String>> result, int n, int pos, char[][] board) {
        if (pos == n) {
            List<String> current = new ArrayList<>();
            for (int i=0; i<board.length; i++) {
                String s = new String(board[i]);
                current.add(s);
            }
            result.add(current);
            return;
        }
        for (int i=0; i<n; i++) {
            if (isValid(board, i, pos)) {
                board[i][pos] = 'Q';
                backtrack(result, n, pos+1, board);
            }
                board[i][pos] = '.';
        }
    }
    
    public boolean isValid(char [][] board, int x, int y) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] == 'Q' && (x + y == i + j || x + j == y + i || x == i))
                    return false;
            }
        }
        return true;
    }
}




class Solution {
    public int totalNQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(result, current, n, 0);
        System.out.println(result);
        return result.size();
    }
    
    public void backtrack(List<List<Integer>> result, List<Integer> current, int n, int pos) {
        if (pos == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i=0; i<n; i++) {
            current.add(i);
            if (isValid(current)) {
                backtrack(result, current, n, pos + 1);
            }
            current.remove(current.size() - 1);
        }
    }
    
    public boolean isValid(List<Integer> current) {
        int limit = current.size() - 1;
        for (int i=0; i<limit; i++) {
            int diff = Math.abs(current.get(i) - current.get(limit));
            if (diff == 0 || diff == limit - i)
                return false;
        }
        return true;
    }
}
