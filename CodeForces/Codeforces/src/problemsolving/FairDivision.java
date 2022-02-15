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
public class FairDivision {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int countOfOne = 0;
			int countOfTwo = 0;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				int candy = sc.nextInt();
				sum += candy;
				if (candy == 1) {
					countOfOne += 1;
				} else {
					countOfTwo += 1;
				}
			}
			if (sum % 2 == 1) {
				System.out.println("NO");
			} else {
				sum = sum / 2;
				if (sum % 2 == 0 || (sum % 2 == 1 && countOfOne != 0)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
}
