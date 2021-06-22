/*
Given a list of moves in a game of tic tac toe, return that state of the game. If player A (the first player to move with X characters) wins, return ”A”. If player B (the second player to move with O characters) wins, return ”B”. Otherwise, if it’s a draw, return ”Draw” and if the game hasn’t finished, return ”Pending”.

Ex: Given the following moves…

moves = [[0,0],[1,0],[1,1],[2,0],[2,2]], return "A" (player A won with three Xs being connected along the diagonal).
*/

class Solution {
    public String tictactoe(int[][] moves) {
        int [] aRow = new int [3];
        int [] aCol = new int [3];
        int [] bRow = new int [3];
        int [] bCol = new int [3];
        int aD1 = 0; // main diagonal
        int aD2 = 0; // secondary
        int bD1 = 0; // main
        int bD2 = 0; // secondary    r + c == 2 for skew
        for (int i=0; i<moves.length; i++) {
            int r = moves[i][0];
            int c = moves[i][1];
            if (i % 2 == 1) {
                if (++bRow[r] == 3 || ++bCol[c] == 3 || r == c && ++bD1 == 3 || r + c == 2 && ++bD2 == 3)
                    return "B";
            }
            else {
                if (++aRow[r] == 3 || ++aCol[c] == 3 || r == c && ++aD1 == 3 || r + c == 2 && ++aD2 == 3)
                    return "A";
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}

