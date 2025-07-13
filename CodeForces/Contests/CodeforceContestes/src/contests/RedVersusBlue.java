package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 05-Jul-2025
 */
public class RedVersusBlue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int r = sc.nextInt();
			int b = sc.nextInt();
			String result = findResult(n, r, b);
			System.out.println(result);
		}
		sc.close();
	}

	private static String findResult(int n, int r, int b) {
		int region = r / (b + 1);
		int extra = r % (b + 1);
		StringBuilder result = new StringBuilder();
		for (int times = 0; times <= b; times++) {
			for (int index = 0; index < region; index++) {
				result.append("R");
			}
			if (extra > 0) {
				result.append("R");
				extra--;
			}
			if (times != b)
				result.append("B");
		}
		return result.toString();
	}

}
