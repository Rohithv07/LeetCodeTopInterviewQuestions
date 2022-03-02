/**
 * 
 */
package problemsolving;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class PuttingPlates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			int[][] grid = new int[row][col];
			for (int i = 0; i < col; i++) {
				if (i % 2 == 0)
					grid[0][i] = 1;
			}
			for (int i = 0; i < col; i++) {
				if (i % 2 == 0)
					grid[row - 1][i] = 1;
			}
			for (int i = 2; i < row - 1; i += 2) {
				if (i == row - 2 && row % 2 == 0) {
					break;
				}
				grid[i][0] = 1;
				grid[i][col - 1] = 1;
			}
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					System.out.print(grid[i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
