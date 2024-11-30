package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 * 30-Nov-2024
 */
public class CoverInWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			System.out.println(minTime(s, n));
		}
		sc.close();
	}

	private static int minTime(String s, int n) {
		if (!s.contains(".")) {
			return 0;
		}
		if (s.contains("...")) {
			return 2;
		}
		int numberOfDots = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '.') {
				numberOfDots++;
			}
		}
		return numberOfDots;
	}

}
