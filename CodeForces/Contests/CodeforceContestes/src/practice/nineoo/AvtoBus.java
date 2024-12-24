package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 24-Dec-2024
 */
public class AvtoBus {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			if (n % 2 == 1 || n < 4) {
				System.out.println(-1);
			} else if (n % 6 != 0) {
				System.out.println((n / 6 + 1) + " " + (n / 4));
			} else if (n % 6 == 0) {
				System.out.println((n / 6) + " " + (n / 4));
			}
		}
		sc.close();
	}

}
