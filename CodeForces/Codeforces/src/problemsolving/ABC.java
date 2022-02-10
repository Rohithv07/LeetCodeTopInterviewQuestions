package problemsolving;

import java.util.Scanner;

public class ABC {

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			if (n == 1) {
				System.out.println("YES");
			}
			else {
				System.out.println(findPossible(s, n));
			}
		}
	}

	private static String findPossible(String s, int n) {
		if (n == 2 && (s.equals("11") || s.equals("00"))) {
			return "NO";
		}
		if (n > 2) {
			return "NO";
		}
		return "YES";
	}
}
