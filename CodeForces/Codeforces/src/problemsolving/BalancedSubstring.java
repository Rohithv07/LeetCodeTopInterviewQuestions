package problemsolving;

import java.util.Scanner;

public class BalancedSubstring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			boolean isFound = false;
			for (int i = 1; i < n; i++) {
				if (s.charAt(i - 1) != s.charAt(i)) {
					System.out.println(i + " " + (i + 1));
					isFound = true;
					break;
				}
			}
			if (!isFound) {
				System.out.println("-1 -1");
			}
		}
	}
}
