/**
 * @author rohithvazhathody
 * @date 25 Jan 2026
 * Project: CodeforceContestes
 * File: MirrorGrid.java
 */

package practice.onetwo;

import java.util.Scanner;

/**
 * 
 */
public class MirrorGrid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			char[][] mat = new char[n][n];
			for (int row = 0; row < n; row++) {
				String s = sc.next();
				for (int col = 0; col < n; col++) {
					mat[row][col] = s.charAt(col);
				}
			}
			int minFlip = findMinFlip(mat);
			System.out.println(minFlip);
		}
		sc.close();
	}

	private static int findMinFlip(char[][] mat) {
		int n = mat.length;
		if (n == 1) {
			return 0;
		}
		int result = 0;
		for (int row = 0; row <= n / 2; row++) {
			for (int col = 0; col < n / 2; col++) {
				int count0 = 0;
				int count1 = 0;
				if (mat[row][col] == '0') {
					count0++;
				} else {
					count1++;
				}
				if (mat[col][n - row - 1] == '0') {
					count0++;
				} else {
					count1++;
				}
				if (mat[n - row - 1][n - col - 1] == '0') {
					count0++;
				} else {
					count1++;
				}
				if (mat[n - col - 1][row] == '0') {
					count0++;
				} else {
					count1++;
				}
				if (count1 == 0 || count0 == 0) {
					continue;
				}
				if (count1 >= count0) {
					result += count0;
					mat[row][col] = '1';
					mat[col][n - row - 1] = '1';
					mat[n - row - 1][n - col - 1] = '1';
					mat[n - col - 1][row] = '1';
				} else {
					result += count1;
					mat[row][col] = '0';
					mat[col][n - row - 1] = '0';
					mat[n - row - 1][n - col - 1] = '0';
					mat[n - col - 1][row] = '0';
				}
			}
		}
		return result;
	}

}
