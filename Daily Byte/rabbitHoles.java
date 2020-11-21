Given a 2D array containing only the following values: -1, 0, 1 where -1 represents an obstacle, 0represents a rabbit hole, and 1represents a rabbit, update every cell containing a rabbit with the distance to its closest rabbit hole.

Note: multiple rabbit may occupy a single rabbit hole and you may assume every rabbit can reach a rabbit hole. A rabbit can only move up, down, left, or right in a single move. Ex: Given the following grid…

-1  0  1
 1  1 -1
 1  1  0
your grid should look like the following after running the function...
-1  0  1
2  1 -1
2  1  0

Ex: Given the following grid…

 1  1  1
 1 -1 -1
 1  1  0
your grid should look like the following after running the function...
4  5  6
3 -1 -1
2  1  0


import java.util.*;
public class Solution {
	public static int [][] hole(int [][] grid) {
		int row = grid.length;
		if (row == 0)
			return null;
		int col = grid[0].length;
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (grid[i][j] == 1)
					dfs(grid, i, j);
			}
		}
		return grid;
	}
	public static void dfs(int [][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1)
			return;
		int temp = grid[i][j];
		grid[i][j] = 0;
		
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int [][] grid = new int [3][3]; 
		for (int i=0; i<3; i++)
			for (int j=0; j<3; j++)
				grid[i][j] = sc.nextInt();
		System.out.println(rabbitHole(grid));
	}
}