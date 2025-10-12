package practice.oneone;

import java.util.Scanner;

/**
 * @author rohithvazhathody 12-Oct-2025
 */
public class JojosIncredibleAdventure {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			System.out.println(findLongestRectangle(s + s));
		}
		sc.close();
	}

	private static long findLongestRectangle(String s) {
		int zero = 0;
		int one = 0;
		int consecutive = 0;
		int maxConsecutive = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '0') {
				consecutive = 0;
				zero++;
			} else {
				consecutive++;
				one++;
			}
			maxConsecutive = Math.max(maxConsecutive, consecutive);
		}
		int size = s.length() / 2;
		if (zero == s.length()) {
			return 0;
		}
		if (one == s.length()) {
			return (long) size * (long) size;
		}
		long seg1 = (long) ((maxConsecutive + 1) / 2);
		long seg2 = (long) ((maxConsecutive + 2) / 2);
		return seg1 * seg2;
	}

}
