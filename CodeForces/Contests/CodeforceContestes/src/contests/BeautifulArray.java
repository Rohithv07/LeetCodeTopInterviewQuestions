package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 26-Jun-2025
 */
public class BeautifulArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long k = sc.nextInt();
			long b = sc.nextInt();
			long s = sc.nextLong();
			long[] result = findBeauty(n, k, b, s);
			if (result == null) {
				System.out.println("-1");
			} else {
				for (long val : result) {
					System.out.print(val + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}

	private static long[] findBeauty(int n, long k, long b, long s) {
		long low = k * b;
		long max = (k * b) + (k - 1) * n;
		if (low > s || max < s) {
			return null;
		}
		long[] result = new long[n];
		result[0] = low;
		s -= low;
		for (int index = 0; index < n; index++) {
			long add = Math.min(k - 1, s);
			result[index] += add;
			s -= add;
		}
		return result;
	}

}
