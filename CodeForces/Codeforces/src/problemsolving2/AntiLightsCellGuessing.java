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
public class AntiLightsCellGuessing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if (n == 1 && m == 1) {
				System.out.println(0);
			} else if (n == 1 || m == 1) {
				System.out.println(1);
			} else
				System.out.println(2);
		}
	}
}
