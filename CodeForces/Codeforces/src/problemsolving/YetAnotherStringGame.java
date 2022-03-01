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
public class YetAnotherStringGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			int length = s.length();
			StringBuilder sb = new StringBuilder();
			if (length == 1) {
				if (s.charAt(0) == 'a') {
					System.out.println("b");
				} else {
					System.out.println("a");
				}
			} else {
				for (int i = 0; i < length; i++) {
					if (i % 2 == 0) {
						if (s.charAt(i) == 'a') {
							sb.append("b");
						} else {
							sb.append("a");
						}
					} else {
						if (s.charAt(i) == 'z') {
							sb.append("y");
						} else {
							sb.append("z");
						}
					}
				}
				System.out.println(sb.toString());
			}
		}
	}
}
