package contests.CodeTON;

import java.util.Scanner;

/**
 * @author rohithvazhathody 23-Nov-2024
 */
public class ShohagLovesStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			int length = s.length();
			if (length == 1) {
				System.out.println(-1);
			} else {
				boolean isFound = false;
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i + 1 < length; i++) {
					if (s.charAt(i) == s.charAt(i + 1)) {
						isFound = true;
						sb.append(s.charAt(i));
						sb.append(s.charAt(i + 1));
						isFound = true;
						break;
					}
				}
				if (isFound) {
					System.out.println(sb.toString());
				} 
				else {
					for (int i = 0; i + 2 < length; i++) {
						char ch1 = s.charAt(i);
						char ch2 = s.charAt(i + 1);
						char ch3 = s.charAt(i + 2);
						if (ch1 != ch2 && ch2 != ch3 && ch1 != ch3) {
							sb.append(ch1).append(ch2).append(ch3);
							isFound = true;
							break;
						}
					}
					if (isFound) {
						System.out.println(sb.toString());
					} else {
						System.out.println(-1);
					}
				}
			}
		}
		sc.close();
	}

}

// aaac
