
// https://www.youtube.com/watch?v=i05Ju7AftcM&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=14


class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char [][] chessBoard = new char [n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessBoard[i][j] = '.';
            }
        }
        backtrack(result, chessBoard, 0, n);
        return result;
    }
    
    private void backtrack(List<List<String>> result, char [][] chessBoard, int col, int n) {
        if (col == n) {
            List<String> currentConfig = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String current = new String(chessBoard[i]);
                currentConfig.add(current);
            }
            result.add(new ArrayList<>(currentConfig));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!canPlace(chessBoard, i, col, n)) {
                continue;
            }
            chessBoard[i][col] = 'Q';
            backtrack(result, chessBoard, col + 1, n);
            chessBoard[i][col] = '.';
        }
    }
    
    private boolean canPlace(char [][] chessBoard, int row, int col, int n) {
        int copyRow = row;
        int copyCol = col;
        // left top diagonal
        while (copyRow >= 0 && copyCol >= 0) {
            if (chessBoard[copyRow][copyCol] == 'Q') {
                return false;
            }
            copyRow--;
            copyCol--;
        }
        // left row
        copyCol = col;
        while (copyCol >= 0) {
            if (chessBoard[row][copyCol] == 'Q') {
                return false;
            }
            copyCol--;
        }
        // left bottom diagonal
        copyCol = col;
        copyRow = row;
        while (copyRow < n && copyCol >= 0) {
            if (chessBoard[copyRow][copyCol] == 'Q') {
                return false;
            }
            copyRow++;
            copyCol--;
        }
        return true;
    }
    
}