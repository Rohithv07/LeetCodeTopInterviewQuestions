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
public class KanaAndTheDragonQuestGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int x = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println(isPossibleToDefeat(x, n, m) ? "YES" : "NO");
		}
	}

	private static boolean isPossibleToDefeat(int x, int n, int m) {
		while (x > 0 && n-- > 0 && x / 2 + 10 < x) {
			x = x / 2 + 10;
		}
		return x - 10 * m <= 0;
	}
}
