This question is asked by Google. A ball is dropped into a special Galton board where at each level in the board the ball can only move right or down. Given that the Galton board has M rows and N columns, return the total number of unique ways the ball can arrive at the bottom right cell of the Galton board.

Ex: Given the following values of M and N…

M = 2, N = 2, return 2.
The possible paths are DOWN -> RIGHT and RIGHT -> DOWN 
Ex: Given the following values of M and N…

M = 4, N = 3, return 10.


// start from the 0,0 -> do the dfs and move to right or down . Continue this until we reach the end, if we reach increment the counter and look for other path by bakctracking

class Solution {
	public static int galtonBoard(int [][] grid, int row, int col) {
		if (row == 1 && col == 1)
			return 1;
		if (row == 2 && col == 2)
			return 2;
		// to track the count of possible paths
		int [] count = new int [1];
		boolean [][] visited = new boolean [row][col];
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				dfsHelper(grid, i, j, count, row, col, visited);
			}
		}
		return count[0];
	}
	public static void dfsHelper(int [][] grid, int i, int j, int [] count, int row, int col, boolean [][] visited) {
		// boundary conditions
		if (i<0 || j<0 || i>=row || j>=col || visited[i][j] == true)	
			return;
		if (grid[i][j] == grid[row-1][col-1]) {
			count[0] += 1;
			return;
		}
		visited[i][j] = true;
		int temp = grid[i][j];
		grid[i][j] = 0;
		dfs(grid, i+1, j, count, row, col, visited);
		dfs(grid, i, j+1, count, row, col, visited);
		grid[i][j] = temp;
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int [][] grid = new int [m][n];
		System.out.println(galtonBoard(grid, m, n));
	}
}
// but this is completely wrong answer as this is considering all the paths, not the unique paths and backtracking is not the way to go as it will consider all the paths and returns the count of all possible paths.
// so whats to consider now, we need only unique path and we also need the count
// we can onnly move right or down. So dynamic programming is the way to go


class Solution {
	public static int galtonBoard(int row, int col) {
		// base condition
		if (row == 1 && col == 1)
			return 1;
		if (row == 2 && col == 2)
			return 2;
		// create a dp array of length row and col
		int [][] dp = new int [row][col];
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 1;
				else
					// else the sum if we move right and down
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[row-1][col-1];
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(galtonBoard(m, n));
	}
}
