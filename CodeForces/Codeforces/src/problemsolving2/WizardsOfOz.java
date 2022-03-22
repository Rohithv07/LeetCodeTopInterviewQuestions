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
public class WizardsOfOz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			System.out.println(findLargestNumber(n));
		}
	}

	private static String findLargestNumber(int n) {
		StringBuilder sb = new StringBuilder();
		if (n == 1) {
			sb.append(9);
			return sb.toString();
		}
		if (n == 2) {
			sb.append(98);
			return sb.toString();
		}
		if (n == 3) {
			sb.append(989);
			return sb.toString();
		}
		sb.append(989);
		for (int i = 3; i < n; i++) {
			int value = (i - 3) % 10;
			sb.append(value);
		}
		return sb.toString();
	}
}
