This question is asked by Amazon. Given a 2D matrix that represents a gold mine, where each cell’s value represents an amount of gold, return the maximum amount of gold you can collect given the following rules:

You may start and stop collecting gold from any position
You can never visit a cell that contains 0 gold
You cannot visit the same cell more than once
From the current cell, you may walk one cell to the left, right, up, or down
Ex: Given the following gold mine…

goldMine = [
    [0,2,0],
    [8,6,3],
    [0,9,0]
],
return 23 (start at 9 and then move to 6 and 8 respectively)

// actually we can start by traversing inside the matrix, and start with the maximum value. then we can check on the top,left, right, bottom and continue with the next one.
// we need to keep track of the maximum everytime when we visit each possible cell. and return this maximum at last.
// but this will be exponential.
// this will be exponential time complexity.

// more efficient way will be doing a depth first search on the mine.
// 1. we traverse through the matrix and start dfs when we do not see a 0 cell.
// now inside the function, we check for the base condition to exit the function, and we update the maximum here.
// else we do the dfs considering all the left, right, top, bottom direction and update the current gold in hand.


// Time: O(4 * 3^k), where k <= 25 is the number of cells that have gold. Because the first cell has up to 4 choices, the (k-1) remain cells have up to 3 choices. And we make k different gold cells as first cell. So k * 4*3^(k-1) = 4 * 3^k.

public class Solution {
	public int getMaximumGold(int [][] grid) {
		int [] maximum = new int [1];
        	int row = grid.length;
		int col = grid[0].length;
		// we traverse through the grid and do the dfs if we do not have a 0
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (grid[i][j] != 0)
					dfs(grid, i, j, 0, maximum);
			}
		}
		return maximum[0];
	}
	public void dfs(int [][] grid, int row, int col, int currentGold, int [] maximum) {
		// base condition to update maximum and return
		if (row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col] == 0) {
			maximum[0] = Math.max(maximum[0], currentGold);
			return;
		}	
		// store the current cell value to temp variable and save 0 inside that cell
		int temp = grid[row][col];
		grid[row][col] = 0;
		// we do dfs on left, right, up, bottom
		dfs(grid, row, col-1, currentGold+temp, maximum);
		dfs(grid, row, col+1, currentGold+temp, maximum);
		dfs(grid, row-1, col, currentGold+temp, maximum);
		dfs(grid, row+1, col, currentGold+temp, maximum);
		// convert back the grid cell to former value
		grid[row][col] = temp;
	}
}
