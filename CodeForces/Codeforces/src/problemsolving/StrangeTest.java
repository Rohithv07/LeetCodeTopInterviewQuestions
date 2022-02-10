package problemsolving;

import java.util.Scanner;

public class StrangeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(minimumStepsToMakeEqual(a, b));
		}
	}

	private static long minimumStepsToMakeEqual(int a, int b) {
		long count = b - a;
		for (int i = a; i < b; i++) {
			int incrementedB = 0;
			for (int j = 21; j >= 0; j--) {
				if ((1 & (b >> j)) == 1) {
					incrementedB ^= (1 << j);
				} else {
					if (((i >> j) & 1) == 1) {
						incrementedB ^= (1 << j);
						break;
					}
				}
			}
			count = Math.min(count, i - a - b + (i | incrementedB) + 1);
		}

		return count;
	}
}
