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
public class ThreeFriends {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long c = sc.nextLong();
			long absValue = Math.abs(a - b) + Math.abs(a - c) + Math.abs(b - c);
			long result = Math.max(absValue - 4, 0);
			System.out.println(result);
		}
	}
}
