package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 14-Sept-2025
 */
public class SublimeSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int x = sc.nextInt();
			int n = sc.nextInt();
			if (n % 2 == 0) {
				System.out.println(0);
			} else {
				System.out.println(x);
			}
		}
		sc.close();
	}

}
