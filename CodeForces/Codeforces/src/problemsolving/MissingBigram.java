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
public class MissingBigram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			sc.nextLine();
			String s = sc.nextLine();
			String[] split = s.split(" ");
			StringBuilder sb = new StringBuilder(split[0]);
			for (int i = 1; i < n - 2; i++) {
				if (split[i - 1].charAt(1) == split[i].charAt(0)) {
					sb.append(split[i].charAt(1));
				} else {
					sb.append(split[i]);
				}
			}
			String answer = sb.toString();
			if (answer.length() != n) {
				answer += 'a';
			}
			System.out.println(answer);
		}
	}
}
