package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 15-Dec-2024
 */
public class LongestDivisorsInterval {

	/**
	 * @param args So, it's enough to check intervals with 𝑙=1, i.e., find the
	 *             smallest 𝑥that does not divide 𝑛. The answer is 𝑥−1.
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			if (n % 2 == 1) {
				System.out.println(1);
			} else {
				int count = 1;
				while (n % count == 0) {
					count++;
				}
				System.out.println(count - 1);
			}
		}
		sc.close();
	}

}
