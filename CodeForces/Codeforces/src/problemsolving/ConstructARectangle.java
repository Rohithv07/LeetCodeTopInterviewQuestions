package problemsolving;

import java.util.Scanner;

public class ConstructARectangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int l1 = sc.nextInt();
			int l2 = sc.nextInt();
			int l3 = sc.nextInt();
			if ((l1 + l2 + l3) % 2 == 0 && ((l1 == l2 || l2 == l3 || l3 == l1)
					|| (l1 == (l2 + l3) || l2 == (l3 + l1) || l3 == (l1 + l2)))) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}
}
