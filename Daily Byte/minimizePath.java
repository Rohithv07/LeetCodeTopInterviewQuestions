This question is asked by Google. Given an NxM matrix, grid, where each cell in the matrix represents the cost of stepping on the current cell, return the minimum cost to traverse from the top-left hand corner of the matrix to the bottom-right hand corner.
Note: You may only move down or right while traversing the grid.

Ex: Given the following grid…

grid = [
    [1,1,3],
    [2,3,1],
    [4,6,1]
], return 7.
The path that minimizes our cost is 1->1->3->1->1 which sums to 7.

// dp problem

import java.util.*;
public class Solution {
	public static int minimumPath(int [][] grid) {
		for (int i=1; i<grid.length; i++)
			grid[i][0] += grid[i-1][0];
		for (int j=1; j<grid[0].length; j++)
			grid[0][j] += grid[0][j-1];
		for (int i=1; i<grid.length; i++) {
			for (int j=1; j<grid[0].length; j++) {
				grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
			}
		}
		return grid[grid.length-1][grid[0].length-1];
	}
	public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
		int [][] grid = new int [3][3];
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++)
                grid[i][j] = sc.nextInt();
        }
		System.out.println(minimumPath(grid));
	}
}