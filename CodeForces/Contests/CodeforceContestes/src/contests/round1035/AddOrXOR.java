package contests.round1035;

import java.util.Scanner;

/**
 * @author rohithvazhathody 05-Jul-2025
 */
public class AddOrXOR {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long x = sc.nextLong();
			long y = sc.nextLong();
			if (a == b) {
				System.out.println(0);
			} else if (a > b) {
				if ((a ^ 1) == b) {
					System.out.println(y);
				} else {
					System.out.println(-1);
				}
			} else {
				long cost = 0;
				while (a != b) {
					long adding = a + 1;
					long xor = a ^ 1;
					if (adding > xor) {
						cost += x;
						a += 1;
					} else if (adding < xor) {
						cost += y;
						a ^= 1;
					} else {
						if (x > y) {
							cost += y;
							a ^= 1;
						} else {
							cost += x;
							a += 1;
						}
					}
				}
				System.out.println(cost);
			}
		}
		sc.close();
	}

}
