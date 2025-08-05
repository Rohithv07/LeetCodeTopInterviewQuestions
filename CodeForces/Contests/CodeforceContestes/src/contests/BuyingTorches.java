package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 05-Aug-2025
 */
public class BuyingTorches {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long x = sc.nextInt();
			long y = sc.nextInt();
			long k = sc.nextInt();
			long minimumTrade = findMinimumTrade(x, y, k);
			System.out.println(minimumTrade);
		}
		sc.close();
	}

	private static long findMinimumTrade(long x, long y, long k) {
		long totalSticks = (k * y) + (k - 1);
		long xTrade = x - 1;
		return ((totalSticks + xTrade - 1) / (xTrade)) + k;
	}

}
