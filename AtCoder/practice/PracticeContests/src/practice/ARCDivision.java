/**
 * 
 */
package practice;

import java.util.Scanner;

/**
 * 
 */
public class ARCDivision {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int initialRating = sc.nextInt();
		int[][] d = new int[n][2];
		for (int i = 0; i < n; i++) {
			d[i][0] = sc.nextInt();
			d[i][1] = sc.nextInt();
		}
		System.out.println(finalRating(n, initialRating, d));
		sc.close();
	}

	private static int finalRating(int n, int initialRating, int[][] d) {
		for (int[] dd : d) {
			int division = dd[0];
			int increment = dd[1];
			if (division == 1) {
				if (initialRating >= 1600 && initialRating <= 2799) {
					initialRating += increment;
				}
			} else if (division == 2) {
				if (initialRating >= 1200 && initialRating <= 2399) {
					initialRating += increment;
				}
			}
		}
		return initialRating;
	}

}
