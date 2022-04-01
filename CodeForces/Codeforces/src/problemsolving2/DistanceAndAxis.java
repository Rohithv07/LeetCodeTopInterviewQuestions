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
public class DistanceAndAxis {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int a = sc.nextInt();
			int k = sc.nextInt();
			System.out.println(findMinMove(a, k));
		}
	}

	private static int findMinMove(int a, int k) {
		if (a < k) {
			return k - a;
		}
		return (a - k) % 2;
	}
}
