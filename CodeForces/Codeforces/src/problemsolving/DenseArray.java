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
public class DenseArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int last = sc.nextInt();
			int result = 0;
			for (int i = 1; i < n; i++) {
				int now = sc.nextInt();
				int min = Math.min(last, now);
				int max = Math.max(last, now);
				while (min * 2 < max) {
					result++;
					min *= 2;
				}
				last = now;
			}
			System.out.println(result);
		}
	}
}
