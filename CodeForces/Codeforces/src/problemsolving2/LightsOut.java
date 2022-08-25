/**
 * 
 */
package problemsolving2;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class LightsOut {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] grid = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int current = grid[i][j];
				int left = j - 1 >= 0 ? grid[i][j - 1] : 0;
				int right = j + 1 < 3 ? grid[i][j + 1] : 0;
				int top = i - 1 >= 0 ? grid[i - 1][j] : 0;
				int bottom = i + 1 < 3 ? grid[i + 1][j] : 0;
				int total = current + left + right + top + bottom;
				if (total % 2 == 0) {
					System.out.print(1);
				} else {
					System.out.print(0);
				}
			}
			System.out.println();
		}
	}
}
