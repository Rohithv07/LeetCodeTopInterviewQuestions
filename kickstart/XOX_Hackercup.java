You're playing a game against an opponent on a grid of cells with NN rows and NN columns. All of the cells are initially empty, and both players normally take turns placing symbols in empty cells (with one player placing Xs and the other placing Os) until a row and/or column becomes entirely filled with one player's symbols (at which point the game ends with that player winning) or all of the cells have been filled without either player winning (in which case the game ends in a draw). Note that a player filling an entire diagonal with their symbols does not cause them to win.
This particular game is in the process of being played, with you placing Xs and your opponent placing Os. The current state of the cell in the iith row from the top and jjth column from the left is one of the following:
If C_{i,j}C 
i,j
​
  = ".", the cell is still empty
If C_{i,j}C 
i,j
​
  = "X", an X has been placed in the cell
Otherwise, if C_{i,j}C 
i,j
​
  = "O", an O has been placed in the cell
In the game's current state, both players have made an equal number of turns (in other words, the number of Xs is the same as the number of Os), neither player has won yet, and the game has not yet ended in a draw (meaning that at least one cell is still empty).
Your opponent has just turned their back, giving you the opportunity to immediately place as many additional Xs on the board as you'd like, in any set of empty cells. Determine the minimum number of additional Xs you must place such that placing them would cause you to immediately win (due to a row and/or a column becoming entirely filled with Xs), if this is possible at all. If it is possible, you should also determine the number of different sets of cells in which that minimum number of Xs could be placed. Two sets of cells are considered to be different if either of them includes at least one cell which the other doesn't.
Constraints
1 \le T \le 701≤T≤70
2 \le N \le 502≤N≤50
C_{i,j} \in \{C 
i,j
​
 ∈{., X, O\}}
The sum of NN across all test cases is at most 2{,}0002,000.
Input
Input begins with an integer TT, the number of games you play against your opponent. For each game, there is first a line containing the integer NN. Then, NN lines follow, the iith of which contains the NN characters C_{i,1..N}C 
i,1..N
​
 .
Output
For the iith game, print a line containing "Case #i: " follow by "Impossible" if you cannot immediately win, or two integers if you can: the minimum number of additional Xs you must place to do so, and the number of different sets of cells in which that minimum number of Xs could be placed.
Sample Explanation
In the first case, there's one way to place just 11 additional X and win. You can place it in the bottom-left corner (thus filling the entire left column):
  XO
  X.
In the second case, there are two possible ways to place 11 additional X and win:
  X.  XX
  XO  .O
In the third case, you'll need to place 33 Xs to win, and you could choose any of the following 66 sets of cells to place them in:
  XXX  ...  ...  X..  .X.   ..X
  ...  XXX  ...  X..  .X.   ..X
  ...  ...  XXX  X..  .X.   ..X
In the fourth case, you could place 22 additional Xs to form either of the following 22 configurations:
  XOX  .OX
  X..  XXX
  X.O  ..O
In the sixth case, even if you place Xs in all 33 remaining empty cells, you cannot win.
Sample Input
8
2
XO
..
2
X.
.O
3
...
...
...
3
.OX
X..
..O
3
OXO
X.X
OXO
3
.XO
O.X
XO.
4
X...
.O.O
.XX.
O.XO
5
OX.OO
X.XXX
OXOOO
OXOOO
XXXX.
Sample Output
Case #1: 1 1
Case #2: 1 2
Case #3: 3 6
Case #4: 2 2
Case #5: 1 1
Case #6: Impossible
Case #7: 2 2
Case #8: 1 2






import java.util.*;

public class XOX {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			char[][] board = new char[n][n];
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = 0; j < n; j++) {
					board[i][j] = s.charAt(j);
				}
			}
			Pair minimumTime = finishGame(board, n);
			if (minimumTime.count == 0 || minimumTime.minTime == Integer.MAX_VALUE) {
				System.out.println("Case #" + t + ": Impossible");
			} else {
				System.out.println("Case #" + t + ": " + minimumTime.minTime + " " + minimumTime.count);
			}
		}
		sc.close();
	}

	private static Pair finishGame(char[][] board, int n) {
		Pair row = findRow(board, n);
		Pair col = findCol(board, n);
		int finalReplacement = 0;
		if (row.minTime < col.minTime) {
			finalReplacement = row.minTime;
		} else {
			finalReplacement = col.minTime;
		}
		if (finalReplacement == 1) {
			int x = 0;
			int y = 0;
			Set<String> common = new HashSet<>();
			for (int i=0; i<n; i++) {
				int countX = 0;
				int countDot = 0;
				for (int j=0; j<n; j++) {
					if (board[j][i] == 'X') {
						countX += 1;
					} else if (board[j][i] == '.') {
						x = i;
						y = j;
						countDot += 1;
					} else if (board[j][i] == 'O') {
						break;
					}
				}
				if (countDot + countX == n && countDot == 1) {
					StringBuilder cord = new StringBuilder();
					cord.append(x).append("#").append(y);
					common.add(cord.toString());
				}
			}
			x = 0;
			y = 0;
			for (int i=0; i<n; i++) {
				int countX = 0;
				int countDot = 0;
				for (int j=0; j<n; j++) {
					if (board[i][j] == 'X') {
						countX += 1;
					} else if (board[i][j] == '.') {
						x = j;
						y = i;
						countDot += 1;
					} else if (board[i][j] == 'O') {
						break;
					}
				}
				if (countDot + countX == n && countDot == 1) {
					StringBuilder cord = new StringBuilder();
					cord.append(x).append("#").append(y);
					common.add(cord.toString());
				}
			}
			return new Pair(finalReplacement, common.size());
			/*
			int specialCase = 0;
			if (row.minTime == col.minTime) {
				for (int i = 0; i < n; i++) {
					int countX = 0;
					int countDot = 0;
					for (int j = 0; j < n; j++) {
						if (board[j][i] == 'X') {
							countX += 1;
						} else if (board[j][i] == '.') {
							countDot += 1;
						} else if (board[j][i] == 'O') {
							break;
						}
					}
					if (countDot + countX == n && countDot == 1) {
						specialCase += 1;
					}
				}
			} else if (col.minTime == 1) {
				for (int i = 0; i < n; i++) {
					int countX = 0;
					int countDot = 0;
					for (int j = 0; j < n; j++) {
						if (board[j][i] == 'X') {
							countX += 1;
						} else if (board[j][i] == '.') {
							countDot += 1;
						} else if (board[j][i] == 'O') {
							break;
						}
					}
					if (countDot + countX == n && countDot == 1) {
						specialCase += 1;
					}
				}
			} else if (row.minTime == 1) {
				for (int i = 0; i < n; i++) {
					int countX = 0;
					int countDot = 0;
					for (int j = 0; j < n; j++) {
						if (board[i][j] == 'X') {
							countX += 1;
						} else if (board[i][j] == '.') {
							countDot += 1;
						} else if (board[i][j] == 'O') {
							break;
						}
					}
					if (countDot + countX == n && countDot == 1) {
						specialCase += 1;
					}
				}
			}
			return new Pair(finalReplacement, specialCase);
			*/
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			int countX = 0;
			int countDot = 0;
			for (int j = 0; j < n; j++) {
				if (board[j][i] == 'X') {
					countX += 1;
				} else if (board[j][i] == '.') {
					countDot += 1;
				} else if (board[j][i] == 'O') {
					break;
				}
			}
			if (countX + countDot == n) {
				if (finalReplacement == countDot)
					count++;
			}
		}

		for (int i = 0; i < n; i++) {
			int countX = 0;
			int countDot = 0;
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'X') {
					countX += 1;
				} else if (board[i][j] == '.') {
					countDot += 1;
				} else if (board[i][j] == 'O') {
					break;
				}
			}
			if (countX + countDot == n) {
				if (finalReplacement == countDot)
					count++;
			}
		}

		return new Pair(finalReplacement, count);

	}

	private static Pair findCol(char[][] board, int n) {
		int replacement = Integer.MAX_VALUE;
		int count = 0;
		for (int i = 0; i < n; i++) {
			int countX = 0;
			int countDot = 0;
			for (int j = 0; j < n; j++) {
				if (board[j][i] == 'X') {
					countX += 1;
				} else if (board[j][i] == '.') {
					countDot += 1;
				} else if (board[j][i] == 'O') {
					break;
				}
			}
			if (countX + countDot == n) {
				if (replacement == countDot)
					count++;
				else if (replacement > countDot) {
					replacement = countDot;
					count = 1;
				}
			}
		}
		return new Pair(replacement, count);
	}

	private static Pair findRow(char[][] board, int n) {
		int replacement = Integer.MAX_VALUE;
		int count = 0;
		for (int i = 0; i < n; i++) {
			int countX = 0;
			int countDot = 0;
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'X') {
					countX += 1;
				} else if (board[i][j] == '.') {
					countDot += 1;
				} else if (board[i][j] == 'O') {
					break;
				}
			}
			if (countX + countDot == n) {
				if (replacement == countDot)
					count++;
				else if (replacement > countDot) {
					replacement = countDot;
					count = 1;
				}
			}
		}
		return new Pair(replacement, count);
	}

}

class Pair {
	int minTime;
	int count;

	public Pair(int minTime, int count) {
		this.minTime = minTime;
		this.count = count;
	}
}