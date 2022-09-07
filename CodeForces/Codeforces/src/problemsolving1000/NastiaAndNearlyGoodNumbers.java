/**
 * 
 */
package problemsolving1000;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class NastiaAndNearlyGoodNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			if (b == 1) {
				System.out.println("NO");
			} else {
				long result1 = a;
				long result2 = a * b;
				long result3 = a * (b + 1);
				System.out.println("YES");
				System.out.println(result1 + " " + result2 + " " + result3);
			}
		}
	}
}
