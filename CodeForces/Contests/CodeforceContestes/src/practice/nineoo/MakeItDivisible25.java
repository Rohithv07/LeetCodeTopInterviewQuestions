package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 05-Jan-2025
 */
public class MakeItDivisible25 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			System.out.println(minOp(s));
		}
		sc.close();
	}

	private static int minOp(String s) {
		String[] onlyPossible = { "00", "25", "50", "75" };
		int result = 101;
		for (String possible : onlyPossible) {
			result = Math.min(result, possibleResult(s, possible));
		}
		return result;
	}

	private static int possibleResult(String s, String possible) {
		int right = s.length() - 1;
		int result = 0;
		while (right >= 0 && s.charAt(right) != possible.charAt(1)) {
			result++;
			right--;
		}
		if (right < 0) {
			return 101; // any max value
		}
		right--;
		while (right >= 0 && s.charAt(right) != possible.charAt(0)) {
			result++;
			right--;
		}
		return right < 0 ? 101 : result;
	}

}
