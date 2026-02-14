/**
 * @author rohithvazhathody
 * @date 8 Feb 2026
 * Project: CodeforceContestes
 * File: LawnMover.java
 */

package contestes.round1078;

import java.util.Scanner;

/**
 * 
 */
public class LawnMover {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			long w = sc.nextLong();
			long maxBoard = findMaxBoard(n, w);
			System.out.println(maxBoard);
		}
		sc.close();
	}

	private static long findMaxBoard(long n, long w) {
		return n - (n / w);

	}

}

/**
 * 
 * 1 4 7
 * 
 * 2 6 10
 * 
 * 
 * 2 6 10
 * 
 * 1000 - 42
 * 
 * 
 * 
 */
