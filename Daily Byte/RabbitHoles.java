/*
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
*/


import java.util.*;

public class RabbitHoles {

	public static int[][] distanceToHole(int [][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int [][] result = new int [row][col];
		Queue<int[]> queue = new LinkedList<>();
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (grid[i][j] == 0)
					queue.add(new int[]{i, j});
				else if (grid[i][j] == 1)
					grid[i][j] = Integer.MAX_VALUE;
			}
		}
		int [][] directions = new int [][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		while (!queue.isEmpty()) {
			int count = 0;
			int [] current = queue.poll();
			int x = current[0];
			int y = current[1];
			for (int [] dir : directions) {
				int newX = dir[0] + x;
				int newY = dir[1] + y;
				if (newX < 0 || newY < 0 || newX >= row || newY >= col || grid[newX][newY] == -1 || grid[newX][newY] <= grid[x][y] + 1)
					continue;
				queue.add(new int []{newX, newY});
				grid[newX][newY] = grid[x][y] + 1;
			}
		}
		return grid;
	}

	// public static int dfsHelper(int [][] grid, int i, int j) {
	// 	if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1)
	// 		return 0;
	// 	int counter = 0;
	// 	if (grid[i][j] == 0) {

	// 		return counter;
	// 	}
	// 	int temp = grid[i][j];
	// 	grid[i][j] = -1;
	// 	counter = dfsHelper(grid, i-1, j) + dfsHelper(grid, i+1, j) + dfsHelper(grid, i, j-1) + dfsHelper(grid, i, j+1);
	// 	return counter;
	// }

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] grid = new int [n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		int [][] updatedGrid = distanceToHole(grid);
		for (int i=0; i<n; i++) {
			System.out.println();
			for (int j=0; j<n; j++) {
				System.out.print(updatedGrid[i][j] + " ");
			}
		}
	}
}