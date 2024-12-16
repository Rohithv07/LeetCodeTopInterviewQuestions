package contests.round993;

import java.util.Scanner;

/**
 * @author rohithvazhathody 15-Dec-2024
 */
public class InsaneProblem {

	/**
	 * @param args
	 * commented code is TLE
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long k = sc.nextLong();
			long l1 = sc.nextLong();
			long r1 = sc.nextLong();
			long l2 = sc.nextLong();
			long r2 = sc.nextLong();
			long count = 0;
			long r = 1;
			while (r <= r2 / l1) {
				long low = Math.max(l1, (l2 + r - 1) / r);
				long high = Math.min(r1, r2/r);
				if (low <= high) {
					count += (high - low + 1);
				}
				r *= k;
			}
//			for (long i = l1; i <= r1; i++) {
//				long temp1 = (l2 + i - 1) / i;
//				long temp2 = (r2) / i;
//				if (temp1 > temp2) {
//					continue;
//				}
//				long p = 1;
//				while (p <= temp2) {
//					if (p >= temp1) {
//						count++;
//					}
//					if (p > r2 / k) {
//						break;
//					}
//					p *= k;
//				}
//
//			}
			System.out.println(count);
		}
		sc.close();
	}

}
