package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 04-Aug-2025
 */
public class NumbersBox {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			int[][] grid = new int[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			int maxSum = findMaxGridSum(grid, row, col);
			System.out.println(maxSum);
		}
		sc.close();
	}

	private static int findMaxGridSum(int[][] grid, int row, int col) {
		int negativeCount = 0;
		int totalSum = 0;
		int minValue = 101;
		for (int currentRow = 0; currentRow < row; currentRow++) {
			for (int currentCol = 0; currentCol < col; currentCol++) {
				int gridValue = grid[currentRow][currentCol];
				if (gridValue < 0) {
					negativeCount++;
				}
				totalSum += Math.abs(gridValue);
				minValue = Math.min(minValue, Math.abs(gridValue));
			}
		}
		if (negativeCount % 2 == 0) {
			return totalSum;
		}
		return totalSum - 2 * minValue;
	}

}
