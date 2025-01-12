package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 12-Jan-2025
 */
public class MultiplyBy2DivideBy6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			System.out.println(minimumMoves(n));
		}
		sc.close();
	}

	private static int minimumMoves(int n) {
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return -1;
		}
		int factor2 = 0;
		int factor3 = 0;
		while (n % 2 == 0) {
			n /= 2;
			factor2++;
		}
		while (n % 3 == 0) {
			n /= 3;
			factor3++;
		}
		if (factor2 > factor3) {
			return -1;
		}
		return n == 1 && factor3 >= factor2 ? 2 * factor3 - factor2 : -1;
	}

}
