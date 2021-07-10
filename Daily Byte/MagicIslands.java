/*
You are given a two-dimensional matrix, grid, containing only ones and zeroes where zeroes represent land and ones represent water. An “island” is a group of one or more contiguous zeroes connected four-directionally (i.e. up, down, left and right). A magical island is an island that is completely surrounded by water on all sides four-directionally. Return the total number of magical islands in the grid.

Ex: Given the following grid…

grid = [
  [1, 1, 1],
  [1, 0, 1],
  [1, 1, 1]
], return 1.
Ex: Given the following grid…

grid = [
  [1, 1, 1, 0],
  [1, 0, 1, 0],
  [1, 1, 1, 0]
], return 1 (the island in the right-most column is not entirely surrounded by water to its right for example).
*/

import java.util.*;

public class MagicIslands {

	public static int findNumberOfMagicIslands(int [][] mat, int row, int col) {
		if (mat == null || row == 0)
			return 0;
		int islands = 0;
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (mat[i][j] == 1) {
					islands += dfs(mat, i, j);
				}
			}
		}
		return islands;
	}

	public static int dfs(int [][] mat, int i, int j) {
		if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] != 1) {
			return 0;
		}
		mat[i][j] = 2;
		dfs(mat, i+1, j);
		dfs(mat, i-1, j);
		dfs(mat, i, j+1);
		dfs(mat, i, j-1);
		return 1;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int [][] mat = new int [row][col];
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		System.out.println(findNumberOfMagicIslands(mat, row, col));
	}
}