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
public class WasteSorting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long c1 = sc.nextLong();
			long c2 = sc.nextLong();
			long c3 = sc.nextLong();
			long a1 = sc.nextLong();
			long a2 = sc.nextLong();
			long a3 = sc.nextLong();
			long a4 = sc.nextLong();
			long a5 = sc.nextLong();
			c1 -= a1;
			c2 -= a2;
			c3 -= a3;
			if (c1 < 0 || c2 < 0 || c3 < 0) {
				System.out.println("NO");
			} else {
				long min1 = Math.min(c1, a4);
				long min2 = Math.min(c2, a5);
				a4 -= min1;
				a5 -= min2;
				if (a4 + a5 > c3) {
					System.out.println("NO");
				} else {
					System.out.println("YES");
				}
			}
		}
	}
}
