package contests.round993;

import java.util.Scanner;

/**
 * @author rohithvazhathody 15-Dec-2024
 */
public class HardProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long m = sc.nextLong();
			long a = sc.nextLong();
			long b = sc.nextLong();
			long c = sc.nextLong();
			long count = 0;
			count = Math.min(a, m) + Math.min(b, m) + Math.min(c, (2 * m - Math.min(a, m) - Math.min(b, m)));
			System.out.println(count);
		}
		sc.close();
	}

}
