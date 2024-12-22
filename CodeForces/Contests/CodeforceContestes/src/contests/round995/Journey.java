package contests.round995;

import java.util.Scanner;

/**
 * @author rohithvazhathody 22-Dec-2024
 */
public class Journey {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long a = sc.nextLong();
			long b = sc.nextLong();
			long c = sc.nextLong();
			long total = a + b + c;
			if (a == n) {
				System.out.println(1);
			} else if (a + b == n) {
				System.out.println(2);
			} else if (a + b + c == n) {
				System.out.println(3);
			} else {
				long day = 3;
				long possible = n / total;
				long full = possible * total;
				day = possible * 3;
				long remaining = n - full;
				if (remaining == 0) {
					System.out.println(day);
				} else if (remaining - a <= 0) {
					System.out.println(day + 1);
				} else if (remaining - a - b <= 0) {
					System.out.println(day + 2);
				} else {
					System.out.println(day + 3);
				}

			}
		}
		sc.close();
	}

}
