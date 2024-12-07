package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 07-Dec-2024
 */
public class WalkingMaster {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long c = sc.nextLong();
			long d = sc.nextLong();
			if (a == c && b == d) {
				System.out.println(0);
			} else {
				if (b > d) {
					System.out.println(-1);
				} else {
					long movesNeeded = d - b;
					a = a + movesNeeded;
					if (a < c) {
						System.out.println(-1);
					} else {
						movesNeeded += (a - c);
						System.out.println(movesNeeded);
					}
				}
			}
		}
		sc.close();
	}

}
