package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 28-Feb-2025
 */
public class ThePlayNeverEnds {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long k = sc.nextLong();
			long mod = k % 3;
			if (mod == 1l) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

}
