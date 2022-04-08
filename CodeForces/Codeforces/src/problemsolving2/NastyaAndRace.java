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
public class NastyaAndRace {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int left = n * (a - b);
			int right = n * (a + b);
			if (right < (c - d) || (c + d) < left) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}
