package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 14-Dec-2024
 */
public class VasilijeInCasac {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			long x = sc.nextLong();
			long k = sc.nextLong();
			// k must be between minSum and maxSum for k numbers
			if (2 * k >= x * (x + 1) && 2 * k <= n * (n + 1) - (n - x) * (n - x + 1)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

}

// a1 + a2 + .. + ak = x
