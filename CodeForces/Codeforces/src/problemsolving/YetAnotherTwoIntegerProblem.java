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
public class YetAnotherTwoIntegerProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a == b) {
				System.out.println("0");
			} else {
				if (a > b) {
					int temp = a;
					a = b;
					b = temp;
				}
				int mainDiff = b - a;
				int factor = a % 10 == b % 10 ? mainDiff / 10 : mainDiff / 10 + 1;
				System.out.println(factor);
			}
		}
	}
}
