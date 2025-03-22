package contests.round1011;

import java.util.Scanner;

/**
 * @author rohithvazhathody 22-Mar-2025
 */
public class ServalAndStringTheory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			String s = sc.next();
			System.out.println(isPossible(n, k, s));
		}
		sc.close();

	}

	private static String isPossible(int n, int k, String s) {
		if (n == 1) {
			return "NO";
		}
		String reverse = findReverse(s);
		if (s.compareTo(reverse) < 0) {
			return "YES";
		}
		for (int i = 0; i + 1 < n; i++) {
			if (s.charAt(i) != s.charAt(i + 1) && k > 0) {
				return "YES";
			}
		}
		return "NO";
	}

	private static String findReverse(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	}

}
