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
public class Square {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int a1 = sc.nextInt();
			int b1 = sc.nextInt();
			int a2 = sc.nextInt();
			int b2 = sc.nextInt();
			if (Math.max(a1, b1) == Math.max(a2, b2) && Math.max(a1, b1) == Math.min(a1, b1) + Math.min(a2, b2)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
}
