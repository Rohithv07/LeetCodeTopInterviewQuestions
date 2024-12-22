package contests.round994;

import java.util.Scanner;

/**
 * @author rohithvazhathody 20-Dec-2024
 */
public class Pspsps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			System.out.println(isPossible(s.toCharArray(), n));
		}
		sc.close();
	}

	private static String isPossible(char[] charArray, int n) {
		if (charArray[0] == 's') {
			charArray[0] = '.';
		}
		if (charArray[n - 1] == 'p') {
			charArray[n - 1] = '.';
		}
		boolean foundP = false;
		boolean foundS = false;
		for (char ch : charArray) {
			if (ch == 'p') {
				foundP = true;
			} else if (ch == 's') {
				foundS = true;
			}
		}
		return foundP && foundS ? "NO" : "YES";
	}

}
