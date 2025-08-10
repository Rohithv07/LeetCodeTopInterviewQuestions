package contests.round1042;

import java.util.Scanner;

/**
 * @author rohithvazhathody 10-Aug-2025
 */
public class Lever {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];
			for (int index = 0; index < n; index++) {
				a[index] = sc.nextInt();
			}
			for (int index = 0; index < n; index++) {
				b[index] = sc.nextInt();
			}
			int totalCount = findTotalLeverCount(a, b, n);
			System.out.println(totalCount);
		}
		sc.close();
	}

	private static int findTotalLeverCount(int[] a, int[] b, int n) {
		int count = 0;
		for (int index = 0; index < n; index++) {
			if (a[index] > b[index]) {
				count += (a[index] - b[index]);
			}
		}
		return count + 1;
	}

}
