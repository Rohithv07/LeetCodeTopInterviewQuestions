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
public class MinMexCut {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			int count = 0;
			int firstOccurance = -1;
			int secondOccurance = -1;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0') {
					count++;
					if (firstOccurance == -1) {
						firstOccurance = i;
					}
				}
			}
			for (int i = s.length() - 1; i >= 0; i--) {
				if (s.charAt(i) == '0') {
					secondOccurance = i;
					break;
				}
			}
			if (count == 0) {
				System.out.println("0");
			} else {
				if (secondOccurance - firstOccurance + 1 == count) {
					System.out.println("1");
				} else {
					System.out.println("2");
				}
			}
		}
	}
}
