/*
This is same as the rotting orange problem.

Given a 2D array each cells can have one of three values. Zero represents an empty cell, one represents a healthy person, and two represents a sick person. Each minute that passes, any healthy person who is adjacent to a sick person becomes sick. Return the total number of minutes that must elapse until every person is sick.
Note: If it is not possible for each person to become sick, return -1.

Ex: Given the following 2D array grid…

grid = [
    [1,1,1],
    [1,1,0],
    [0,1,2]
], return 4.
[2, 1] becomes sick at minute 1.
[1, 1] becomes sick at minute 2. 
[1, 0] and [0, 1] become sick at minute 3.
[0, 0] and [0, 2] become sick at minute 4.
Ex: Given the following 2D array grid…

grid = [
    [1,1,1],
    [0,0,0],
    [2,0,1]
], return -1.

*/


import java.util.*;

public class InfectionRottingOrange {

	public static int rottingOrange(int [][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();  //[1-> x, 0->y]
		int freshCount = 0;
		int time = 0;
		int [][] directions = new int [][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (grid[i][j] == 2)
					queue.add(new int [] {i, j});
				else if (grid[i][j] == 1)
					freshCount += 1;
			}
		}
		while (!queue.isEmpty() && freshCount > 0) {
			time++;
			int size = queue.size();
			for (int i=0; i<size; i++) {
				int [] xy = queue.poll();
				for (int [] dir : directions) {
					int newX = xy[0] + dir[0];
					int newY = xy[1] + dir[1];
					if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length || grid[newX][newY] == 0 || grid[newX][newY] == 2)
						continue;
					queue.add(new int [] {newX, newY});
					grid[newX][newY] = 2;
					freshCount -= 1;
				}
			}
		}
		return freshCount == 0 ? time : -1;
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
		System.out.println(rottingOrange(grid));
	}
}