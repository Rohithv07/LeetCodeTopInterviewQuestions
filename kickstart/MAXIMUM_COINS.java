Problem
Mike has a square matrix with N rows and N columns. Cell (i,j) denotes the cell present at row i and column j. Cell (1,1) denotes the top left corner of the matrix. Each cell has some amount of coins associated with it and Mike can collect them only if he visits that cell. Ci,j represents the number of coins in cell with row i and column j. From a cell (i,j), Mike can decide to go to cell (i+1,j+1) or cell (i-1,j-1), as long as the cell lies within the boundaries of the matrix and has not been visited yet. He can choose to start the journey from any cell and choose to stop at any point. Mike wants to maximize the number of coins he can collect. Please help him determine the maximum number of coins he can collect.

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins with a line containing the integer N. The next N lines contain N integers each. The j-th integer in the i-th line represents the number of coins Ci,j in cell (i,j).

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the maximum number of coins Mike can collect.

Limits
Time limit: 20 seconds per test set.
Memory limit: 1GB.
1 ≤ T ≤ 100.
0 ≤ Ci,j ≤ 107.

Test Set 1
1 ≤ N ≤ 100.

Test Set 2
1 ≤ N ≤ 103 in at most 10 cases.
1 ≤ N ≤ 100 in all other cases.

Sample

Input
 	
Output
 
2
3
1 2 5
3 6 1
12 2 7
5
0 0 0 0 0
1 1 1 1 0
2 2 2 8 0
1 1 1 0 0
0 0 0 0 0

  
Case #1: 14
Case #2: 9

  
In Sample Case #1, the maximum number of coins collected can be 14, if Mike follows this path: (1,1) -> (2,2) -> (3,3)

In Sample Case #2, the maximum number of coins collected can be 9, if Mike follows this path: (2,3) -> (3,4).






import java.util.*;
public class Solution {
    public static int getMaximumCoin(int[][] grid) {
        int [] maximum = new int [1];
        int row = grid.length;
		int col = grid[0].length;
		boolean [][] visited = new boolean [row][col];
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (visited[i][j] == false)
					dfs(grid, i, j, 0, maximum, visited);
			}
		}
		return maximum[0];
	}
	public static void dfs(int [][] grid, int row, int col, int current, int [] maximum, boolean [][] visited) {
		if (row<0 || col<0 || row>=grid.length || col>=grid[0].length || visited[row][col] == true) {
			maximum[0] = Math.max(maximum[0], current);
			return;
		}
		visited[row][col] = true;
		int temp = grid[row][col];
		grid[row][col] = 0;
		dfs(grid, row-1, col-1, current+temp, maximum, visited);
		dfs(grid, row+1, col+1, current+temp, maximum, visited);
		grid[row][col] = temp;
	}
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k=1; k<=t; k++) {
            int n = sc.nextInt();
            int [][] mat = new int [n][n];
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            System.out.println("Case #" + k+": "+getMaximumCoin(mat));
        }
    }
}
