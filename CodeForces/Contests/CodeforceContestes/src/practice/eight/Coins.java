package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 06-Dec-2024
 */
public class Coins {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			long k = sc.nextLong();
			if (n % 2 == 0 || (n - k) % 2 == 0) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

}
