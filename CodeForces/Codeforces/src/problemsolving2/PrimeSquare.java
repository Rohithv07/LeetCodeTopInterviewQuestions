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
public class PrimeSquare {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[][] mat = findThePrimeSquare(n);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(mat[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	private static int[][] findThePrimeSquare(int n) {
		int[][] mat = new int[n][n];
		if (n == 2) {
			mat[0][0] = 1;
			mat[0][1] = 1;
			mat[1][0] = 1;
			mat[1][1] = 1;
			return mat;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j || j == (i + 1) % n) {
					mat[i][j] = 1;
				}
			}
		}
		return mat;
	}
}
