/*
You are given a special Rubik’s cube that only contains black and white panels. The side of the Rubik’s cube that is facing you is given as a two-dimensional matrix, cube. Each value in cube is either a zero or a one where zero represents a black panel and one represents a white panel. Given the cube, invert it and return the modified cube. Inverting the cube consists of reversing the values in each row and flipping black values to white and white values to black.

Ex: Given the following cube…

cube = [[1, 0], [0, 1], [1, 1]], return [[1,0],[0,1],[0,0]].
*/

import java.util.*;

public class RubiksCube {

	public static void flipTheCube(int [][] cube, int row, int col) {
		// rveerse each row
		for (int [] rows : cube) {
			int left = 0;
			int right = col - 1;
			while (left < right) {
				int temp = rows[left];
				rows[left] = rows[right];
				rows[right] = temp;
				left += 1;
				right -= 1;
			}
		}
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (cube[i][j] == 1)
					cube[i][j] = 0;
				else
					cube[i][j] = 1;
			}
		}
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int [][] cube = new int [row][col];
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				cube[i][j] = sc.nextInt();
			}
		}
		flipTheCube(cube, row, col);
		for (int i=0; i<row; i++) {
			System.out.println();
			for (int j=0; j<col; j++) {
				System.out.print(cube[i][j] + " ");
			}
		}
	}
}

