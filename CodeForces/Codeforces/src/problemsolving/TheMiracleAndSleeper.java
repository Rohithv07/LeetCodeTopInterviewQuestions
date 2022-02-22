/**
 * 
 */
package problemsolving;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class TheMiracleAndSleeper {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			System.out.println(l <= (r / 2) + 1 ? (r - 1) / 2 : r - l);
		}
	}
}
