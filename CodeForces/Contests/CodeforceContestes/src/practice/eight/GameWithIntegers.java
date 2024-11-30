package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 30-Nov-2024
 */
public class GameWithIntegers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			System.out.println(getWinner(n));
		}
		sc.close();
	}

	private static String getWinner(int n) {
		if (n % 3 == 0) {
			return "Second";
		}
		return "First";
	}

}
