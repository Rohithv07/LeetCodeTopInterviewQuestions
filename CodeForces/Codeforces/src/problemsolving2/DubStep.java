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
public class DubStep {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(findTheOriginal(s));
	}

	private static String findTheOriginal(String s) {
		if (!s.contains("WUB")) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) == 'W') {
				if (i + 1 < s.length() && s.charAt(i + 1) == 'U') {
					if (i + 2 < s.length() && s.charAt(i + 2) == 'B') {
						sb.append(" ");
						i += 3;
					} else {
						sb.append('W');
						i++;
					}
				} else {
					sb.append('W');
					i++;
				}
			} else {
				sb.append(s.charAt(i));
				i++;
			}
		}
		if (sb.charAt(0) == ' ') {
			sb.deleteCharAt(0);
		}
		String[] split = sb.toString().split(" ");
		sb = new StringBuilder();
		for (int j = 0; j < split.length - 1; j++) {
			if (split[j].equals("")) {
				continue;
			}
			sb.append(split[j]);
			sb.append(" ");
		}
		sb.append(split[split.length - 1]);
		return sb.toString();
	}
}
