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
public class PhoenixAndPuzzle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			if (n == 1) {
				System.out.println("NO");
			} else {
				if (n % 2 == 0 && isSquare(n / 2)) {
					System.out.println("YES");
				} else if (n % 4 == 0 && isSquare(n / 4)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	private static boolean isSquare(long l) {
		long sqrt = (long)Math.sqrt(l);
		return sqrt * sqrt == l;
	}
}
