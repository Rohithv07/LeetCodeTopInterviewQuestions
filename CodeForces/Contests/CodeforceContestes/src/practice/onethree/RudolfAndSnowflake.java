/**
 * @author rohithvazhathody
 * @date 27 Feb 2026
 * Project: CodeforceContestes
 * File: RudolfAndSnowflake.java
 */

package practice.onethree;

import java.util.Scanner;

/**
 * 
 */
public class RudolfAndSnowflake {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		boolean[] possibleK = new boolean[(int) (1e6 + 1)];
		for (long i = 2; i <= 10000; i++) {
			// (k ^ x - 1) / (k - 1)
			long numerator = i * i * i;
			long denominator = (i - 1);
			long total = (numerator - 1) / denominator;
			while (total <= (int) (1e6)) {
				possibleK[(int) total] = true;
				numerator *= i;
				total = (numerator - 1) / denominator;

			}
		}
		while (test-- > 0) {
			int n = sc.nextInt();
			String snowflakeFormed = findIfSnowFlakeFormed(n, possibleK);
			System.out.println(snowflakeFormed);
		}
		sc.close();
	}

	private static String findIfSnowFlakeFormed(int n, boolean[] possibleK) {
		return possibleK[n] ? "YES" : "NO";
	}

}
