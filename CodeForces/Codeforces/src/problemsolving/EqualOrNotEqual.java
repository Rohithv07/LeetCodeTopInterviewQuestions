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
public class EqualOrNotEqual {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			int countN = 0;
			for (char ch : s.toCharArray()) {
				if (ch == 'N') {
					countN++;
				}
			}
			if (countN != 1) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
}
