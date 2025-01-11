package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 11-Jan-2025
 */
public class OddDivisor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			if ((n & (n - 1)) == 0) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
			}
		}
		sc.close();
	}

}
