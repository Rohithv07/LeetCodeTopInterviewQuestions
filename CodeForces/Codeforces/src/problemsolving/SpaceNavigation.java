package problemsolving;

import java.util.Scanner;

public class SpaceNavigation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			String s = sc.next();
			int u = 0;
			int d = 0;
			int r = 0;
			int l = 0;
			for (char ch : s.toCharArray()) {
				if (ch == 'U') {
					u++;
				} else if (ch == 'D') {
					d++;
				} else if (ch == 'R') {
					r++;
				} else {
					l++;
				}
			}
			if (x > 0 && r >= x) {
				x = 0;
			}
			if (x < 0 && l >= -x) {
				x = 0;
			}
			if (y > 0 && u >= y) {
				y = 0;
			}
			if (y < 0 && d >= -y) {
				y = 0;
			}
			System.out.println((x == 0 && y == 0) ? "YES" : "NO");
		}
	}
}
