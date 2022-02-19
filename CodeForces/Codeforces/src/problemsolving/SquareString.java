package problemsolving;

import java.util.Scanner;

public class SquareString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			if (s.length() % 2 == 1) {
				System.out.println("NO");
			} else {
				int length = s.length();
				int middle = length / 2;
				boolean flag = true;
				for (int i = 0; i < middle; i++) {
					if (s.charAt(i) != s.charAt(middle + i)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
}
