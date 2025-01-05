package contests.hello2025;

import java.util.Scanner;

/**
 * @author rohithvazhathody 04-Jan-2025
 */
public class MexTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long row = sc.nextLong();
			long col = sc.nextLong();
			System.out.println(Math.max(row, col) + 1);
		}
		sc.close();
	}

}
