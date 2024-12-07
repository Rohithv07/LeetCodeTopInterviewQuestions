/**
 * 
 */
package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 */
public class Humidifier2 {

	/**
	 * @param args
	 *
	 */

	private static final int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int d = sc.nextInt();
		char[][] grid = new char[row][col];
		for (int i = 0; i < row; i++) {
			String s = sc.next();
			for (int j = 0; j < col; j++) {
				grid[i][j] = s.charAt(j);
			}
		}
		List<int[]> floors = new ArrayList<>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '.') {
					floors.add(new int[] { i, j });
				}
			}
		}

		int maxHumidified = 0;

		int n = floors.size();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int[] cell1 = floors.get(i);
				int[] cell2 = floors.get(j);

				Set<String> humidified = new HashSet<>();
				humidified.addAll(getHumidifiedCells(cell1[0], cell1[1], row, col, d, grid));
				humidified.addAll(getHumidifiedCells(cell2[0], cell2[1], row, col, d, grid));

				maxHumidified = Math.max(maxHumidified, humidified.size());
			}
		}
		System.out.println(maxHumidified);
		sc.close();
	}

	private static Set<String> getHumidifiedCells(int x, int y, int row, int col, int d, char[][] grid) {
		Set<String> humidified = new HashSet<>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '.' && Math.abs(i - x) + Math.abs(j - y) <= d) {
					humidified.add(i + "," + j);
				}
			}
		}
		return humidified;
	}

}

/*
 * 5 5 2 !#.#. !!!$! !#!#! #!#!# !!$!!
 * 
 * 
 */