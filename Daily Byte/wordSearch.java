This question is asked by Amazon. Given a 2D board that represents a word search puzzle and a string word, return whether or the given word can be formed in the puzzle by only connecting cells horizontally and vertically.

Ex: Given the following board and words…

board =
[
  ['C','A','T','F'],
  ['B','G','E','S'],
  ['I','T','A','E']
]
word = "CAT", return true
word = "TEA", return true
word = "SEAT", return true
word = "BAT", return false


// go through the rows and columns and find the matching startig letter.
// if sea our letter, we do the depth first search from there.
// dfs(board, word, row, column, 0(currentWordLength))
// inside the dfs(), we return true if we have our curentlength = wordlength we are searching.
// we return false, we are at a position which is not equal to the letter we are looking for

public class Solution {
	public boolean wordSearch(char [][] board, String word) {
		int row = board.length;
		int col = board[0].length;
		// traverse through the board to check for the character
		for (int i =0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (word.charAt(0) == board[i][j] && dfs(board, word, i, j, 0))
					return true;
			}
		}	
		return false;
	}
	public boolean dfs(char [][] board, String word, int row, int col, int count) {
		// base condition: if length == wordlength return true		
		if (word.length() == count)
			return true;
		// since we are looking top, down, left, right of board, there can be outof bounds and also we may be at a wrong cell, then return fal.
		if (row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col] != word.charAt(count))
			return false;
		char temp = board[row][col];
		board[row][col] = ' '; // the already visited one is made blank for our own sake, to avoid conflict
		// we check for the all possible directions and see whther we can see the letter we are looking
		boolean possible = dfs(board, word, row+1, col, count+1) ||
				dfs(board, word, row-1, col, count+1) ||
				dfs(board, word, row, col+1, count+1) ||
				dfs(board, word, row, col-1, count+1);
		board[row][col] = temp;
		return possible;
	}
}

