package problemsolving;

import java.util.Scanner;

public class Elections {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int val1 = Math.max(a, Math.max(b, c) + 1);
			int val2 = Math.max(b, Math.max(a, c) + 1);
			int val3 = Math.max(c, Math.max(b, a) + 1);
			System.out.println((val1 - a) + " " + (val2 - b) + " " + (val3 - c));
		}
	}
}
