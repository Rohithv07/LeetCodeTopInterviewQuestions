/**
 * 
 */
package kickstart;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class WiggleWalk {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int instructions = sc.nextInt();
			int row = sc.nextInt();
			int col = sc.nextInt();
			int startRow = sc.nextInt();
			int startCol = sc.nextInt();
			String direction = sc.next();
			char[] directionArray = direction.toCharArray();
			int[] finalPosition = findFinalPosition(row, col, startRow - 1, startCol - 1, directionArray);
			System.out.println("Case #" + t + ": " + (finalPosition[0] + 1) + " " + (finalPosition[1] + 1));
		}
	}

	private static int[] findFinalPosition(int row, int col, int i, int j, char[] directionArray) {
		boolean[][] visited = new boolean[row][col];
		visited[i][j] = true;
		for (char ch : directionArray) {
			if (ch == 'N') {
				while (visited[i][j]) {
					i -= 1;
				}
			} else if (ch == 'E') {
				while (visited[i][j]) {
					j += 1;
				}
			} else if (ch == 'W') {
				while (visited[i][j]) {
					j -= 1;
				}
			} else if (ch == 'S') {
				while (visited[i][j]) {
					i += 1;
				}
			}
			visited[i][j] = true;
		}
		return new int[] { i, j };
	}
}
