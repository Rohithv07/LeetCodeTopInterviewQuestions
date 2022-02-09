package problemsolving;

import java.util.Scanner;

public class DivisionSeven {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			if (n % 7 == 0) {
				System.out.println(n);
			} else {
				System.out.println(findTheNearest(n));
			}
		}
	}

	private static int findTheNearest(int n) {
		int rem = n % 10;
		n -= rem;
		for (int i = 0; i < 10; i++) {
			int current = n + i;
			if (current % 7 == 0) {
				return current;
			}
		}

		return 0;
	}
}