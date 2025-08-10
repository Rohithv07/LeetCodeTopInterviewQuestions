package contests.round1042;

import java.util.Scanner;

/**
 * @author rohithvazhathody 10-Aug-2025
 */
public class AlternatingSeries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] series = findSeries(n);
			for (int s : series) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static int[] findSeries(int n) {
		if (n == 3) {
			return new int[] { -1, 3, -1 };
		}
		int[] result = new int[n];
		for (int index = 0; index < n; index++) {
			if (index % 2 == 0) {
				result[index] = -1;
			} else {
				if (index == n - 1 && n % 2 == 0) {
					result[index] = 2;
				} else {
					result[index] = 3;
				}
			}
		}
		return result;
	}

}
