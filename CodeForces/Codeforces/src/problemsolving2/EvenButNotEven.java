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
public class EvenButNotEven {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			StringBuilder sb = new StringBuilder();
			int count = 0;
			for (char ch : s.toCharArray()) {
				int number = (ch - '0');
				if (number % 2 == 1) {
					if (count < 2) {
						sb.append(ch);
						count++;
					}
				}
			}
			if (count <= 1) {
				System.out.println("-1");
			} else {
				System.out.println(sb.toString());
			}

		}
	}
}
