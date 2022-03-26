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
public class MultiplyBy2DivideBy6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			System.out.println(getMinimumNumberOfMoves(n));
		}
	}

	public static int getMinimumNumberOfMoves(int n) {
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return -1;
		}
		int countOfFactor2 = 0;
		int countOfFactor3 = 0;
		while (n % 2 == 0) {
			n /= 2;
			countOfFactor2++;
		}
		while (n % 3 == 0) {
			n /= 3;
			countOfFactor3++;
		}
		if (countOfFactor2 > countOfFactor3) {
			return -1;
		}
		return n == 1 && countOfFactor3 >= countOfFactor2 ? 2 * countOfFactor3 - countOfFactor2 : -1;
	}
}
