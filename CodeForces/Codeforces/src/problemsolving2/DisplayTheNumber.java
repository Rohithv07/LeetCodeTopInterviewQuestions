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
public class DisplayTheNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			if (n % 2 == 1) {
				System.out.print(7);
				n -= 3;
			}
			while (n > 0) {
				System.out.print(1);
				n -= 2;
			}
			System.out.println();
		}
	}
}
