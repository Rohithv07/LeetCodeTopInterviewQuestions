/**
 * 
 */
package starters;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class DarkLight {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			int k = sc.nextInt();
			if (k == 1) {
				if (n == 0 || n % 4 == 0) {
					System.out.println("On");
				}
				else {
					System.out.println("Ambiguous");
				}
			}
			else if (k == 0) {
				if (n % 4 == 0) {
					System.out.println("Off");
				}
				else {
					System.out.println("On");
				}
			}
		}
	}
}
