package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 25-Dec-2024
 */
public class ABBalance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			System.out.println(findFinalString(s));
		}
		sc.close();
	}

	private static String findFinalString(String s) {
		int n = s.length();
		if (s.charAt(0) == s.charAt(n - 1)) {
			return s;
		}
		if (s.charAt(0) == 'a') {
			return 'b' + s.substring(1);
		}
		return 'a' + s.substring(1);

	}

}
