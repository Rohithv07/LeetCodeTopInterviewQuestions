package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 08-Dec-2024
 */
public class TwoPermutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a == b && b == n) {
				System.out.println("YES");
			} else {
				if (a + b + 2 <= n) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
		sc.close();
	}

}
