The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

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
        char [][] current = new char [n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                current[i][j] = '.';
            }
        }
        backtrack(result, current, n, 0);
        return result;
    }
    
    public void backtrack(List<List<String>> result, char [][] current, int n, int start) {
        if (start == n) {
            List<String> currentAdd = new ArrayList<>();
            for (int i=0; i<n; i++) {
                String s = new String(current[i]);
                currentAdd.add(s);
            }
            result.add(currentAdd);
            return;
        }
        for (int i=0; i<n; i++) {
            if (isValid(current, i, start)) {
                current[i][start] = 'Q';
                backtrack(result, current, n, start + 1);
            }
            current[i][start] = '.';
        }
    }
    
    public boolean isValid(char [][] current, int x, int y) {
        for (int i=0; i<current.length; i++) {
            for (int j=0; j<current[i].length; j++) {
                if (current[i][j] == 'Q' && (x + y == i + j || x + j == y + i || x == i))
                    return false;
            }
        }
        return true;
    }
}
