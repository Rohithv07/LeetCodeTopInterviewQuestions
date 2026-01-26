/**
 * @author rohithvazhathody
 * @date 18 Jan 2026
 * Project: CodeforceContestes
 * File: PrefixMax.java
 */

package contests.round1074;

import java.util.Scanner;

/**
 * 
 */
public class PrefixMax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			long max = Long.MIN_VALUE;
			for (long index = 0; index < n; index++) {
				max = Math.max(max, sc.nextLong());
			}
			System.out.println(max * n);
		}
		sc.close();
	}

}
