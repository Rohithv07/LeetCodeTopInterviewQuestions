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
public class SymmetricMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			boolean isSymmetric = false;
			for (int i = 0; i < n; i++) {
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();
				int num3 = sc.nextInt();
				int num4 = sc.nextInt();
				if (num2 == num3) {
					isSymmetric = true;
				}
			}
			if (m % 2 == 1 || !isSymmetric) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}
