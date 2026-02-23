/**
 * @author rohithvazhathody
 * @date 16 Feb 2026
 * Project: CodeforceContestes
 * File: AndZeroSumBig.java
 */

package practice.onetwo;

import java.util.Scanner;

/**
 * 
 */
public class AndZeroSumBig {

	/**
	 * @param args
	 */

	private static final long MOD = (long) (1e9 + 7);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			long count = findCount(n, k);
			System.out.println(count);
		}
		sc.close();
	}

	private static long findCount(int n, int k) {
		long answer = 1;
		for (int index = 0; index < k; index++) {
			answer = (answer % MOD) * (n % MOD);
		}
		return answer % MOD;
	}

}
