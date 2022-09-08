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
public class MaximumCostDeletion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			String s = sc.next();
			int countOfBlocks = 1;
			for (int i = 1; i < n; i++) {
				if (s.charAt(i) != s.charAt(i - 1)) {
					countOfBlocks++;
				}
			}
			int result = (a * n) + Math.max(b * n, b * (countOfBlocks / 2 + 1));
			System.out.println(result);
		}
	}
}
