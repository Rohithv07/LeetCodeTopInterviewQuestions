/**
 * 
 */
package problemsolving2;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class PrimeSubtraction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long x = sc.nextLong();
			long y = sc.nextLong();
			long diff = Math.abs(x - y);
			if (diff == 1) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}
