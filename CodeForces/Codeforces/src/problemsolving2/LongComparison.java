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
public class LongComparison {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long x1 = sc.nextLong();
			long p1 = sc.nextLong();
			long x2 = sc.nextLong();
			long p2 = sc.nextLong();
			long minimum = Math.min(p1, p2);
			p1 -= minimum;
			p2 -= minimum;
			if (p1 >= 7) {
				System.out.println(">");
			}
			else if (p2 >= 7) {
				System.out.println("<");
			}
			else {
				for (int i = 0; i < p1; i++) {
					x1 *= 10;
				}
				for (int i = 0; i < p2; i++) {
					x2 *= 10;
				}
				if (x1 > x2) {
					System.out.println(">");
				}
				else if (x1 < x2) {
					System.out.println("<");
				}
				else {
					System.out.println("=");
				}
			}
		}
	}
}
