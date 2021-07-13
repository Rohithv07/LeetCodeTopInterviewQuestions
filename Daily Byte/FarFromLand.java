/*
You are given a two-dimensional matrix, grid, that only contains zeroes and ones. Zeroes represent water and ones represent land. Return the furthest distance any cell with water is from any cell with land.
Note: One cell represents a unit distance of one and you may only travel four-directionally from any given cell (i.e. up, down, left, and right). If no land exists within grid, return -1.

Ex: Given the following grid…

grid = [
  [0, 0, 1],
  [0, 0, 0],
  [0, 0, 0]
], return 4 (cell (0, 2) is 4 units away from cell (2, 0)).
Ex: Given the following grid…

grid = [
  [0, 0, 0],
  [0, 1, 0],
  [0, 0, 0]
], return 2.
*/

// idea is to use bfs from every land and calculate the min distance to reach water
// the maximum of those values gives the answer.

import java.util.*;

public class FarFromLand {

	public static int farthestWater(int [][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int n = grid.length;
		boolean [][] visited = new boolean [n][n];
		return bfs(grid, visited);
	}

	public static int bfs(int [][] grid, boolean[][] visited) {
		int [][] directions = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		Queue<int []> queue = new LinkedList<>();
		int result = -1;
		for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[0].length; j++) {
				if (grid[i][j] == 1) {
					visited[i][j] = true;
					queue.offer(new int []{i, j});
				}
			}
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s=0; s<size; s++) {
				int [] current = queue.poll();
				int x = current[0];
				int y = current[1];
				result = Math.max(result, grid[x][y] - 1);
				for (int [] dir : directions) {
					int newX = x + dir[0];
					int newY = y + dir[1];
					if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length || visited[newX][newY])
						continue;
					visited[newX][newY] = true;
					grid[newX][newY] = grid[x][y] + 1;
					queue.offer(new int [] {newX, newY});
				}
			}
		}
		return result == 0 ? -1 : result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] grid = new int [n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		System.out.println(farthestWater(grid));
	}
}




// same approach can be done with checking for i = 0 to size of queue


class Solution {
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0)
            return -1;
        int row = grid.length;
        int col = grid[0].length;
        boolean [][] visited = new boolean [row][col];
        return bfs(grid, visited, row, col);
    }
    
    public int bfs(int [][] grid, boolean [][] visited, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        int [][] directions = new int [][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int result = -1;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    queue.offer(new int [] {i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int [] dir : directions) {
                int newX = dir[0] + x;
                int newY = dir[1] + y;
                if (newX < 0 || newY < 0 || newX >= row || newY >= col || visited[newX][newY]) {
                    continue;
                }
                visited[newX][newY] = true;
                grid[newX][newY] = grid[x][y] + 1;
                result = Math.max(result, grid[newX][newY]);
                queue.offer(new int []{newX, newY});
            }
        }
        return result < 0 ? -1 : result - 1;
    }
}