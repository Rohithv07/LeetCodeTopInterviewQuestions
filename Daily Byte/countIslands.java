Given a 2D array of integers with ones representing land and zeroes representing water, return the number of islands in the grid. Note: an island is one or more ones surrounded by water connected either vertically or horizontally. Ex: Given the following grid…

11000
11010
11001
return 3.
Ex: Given the following grid…

00100
00010
00001
00001
00010
return 4.


import java.util.*;
public class Solution {
	public static int countIslands(int [][] grid, int row, int col) {
		int numberOfIslands = 0;
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (grid[i][j] == 1)
					numberOfIslands += dfs(grid, i, j);
			}
		}
		return numberOfIslands;
	}
	public static int dfs(int [][] grid, int i, int j) {
		if (i >= grid.length || i<0 || j>=grid[0].length || j<0 || grid[i][j] == 0)
			return 0;
		grid[i][j] = 0;
		dfs(grid, i+1, j);
		dfs(grid, i-1, j);
		dfs(grid, i, j-1);
		dfs(grid, i, j+1);
		return 1;
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int [][] grid = new int [row][col];
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		System.out.println(countIslands(grid, row, col));
	}
}

