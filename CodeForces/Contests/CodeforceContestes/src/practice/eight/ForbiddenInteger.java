package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 05-Dec-2024
 */
public class ForbiddenInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int x = sc.nextInt();
			if (x != 1) {
				System.out.println("YES");
				System.out.println(n);
				for (int i = 0; i < n; i++) {
					System.out.print(1 + " ");
				}
				System.out.println();
			} else if (n % 2 == 0 && k > 1) {
				System.out.println("YES");
				System.out.println(n / 2);
				for (int i = 0; i < n / 2; i++) {
					System.out.print(2 + " ");
				}
				System.out.println();
			} else if (k > 2) {
				System.out.println("YES");
				System.out.println(n / 2);
				System.out.print(3 + " ");
				for (int i = 0; i < (n - 3) / 2; i++) {
					System.out.print(2 + " ");
				}
				System.out.println();
			} else
				System.out.println("NO");
		}
		sc.close();
	}

}
