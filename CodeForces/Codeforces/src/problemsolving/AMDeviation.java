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
public class AMDeviation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long a1 = sc.nextLong();
			long a2 = sc.nextLong();
			long a3 = sc.nextLong();
			if ((a1 + a3 - 2 * a2) % 3 == 0) {
				System.out.println("0");
			}
			else {
				System.out.println("1");
			}
		}
	}
}
