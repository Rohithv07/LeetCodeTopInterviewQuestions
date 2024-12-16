package contests.round993;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 * 15-Dec-2024
 */
public class NormalProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			StringBuilder sb = new StringBuilder();
			for (char ch : s.toCharArray()) {
				if (ch == 'p') {
					sb.append('q');
				}
				else if (ch == 'q') {
					sb.append('p');
				}
				else {
					sb.append(ch);
				}
			}
			System.out.println(sb.reverse().toString());
		}
		sc.close();
	}

}
