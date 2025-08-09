package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 08-Aug-2025
 */
public class ReverseASubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		int[] pos = findSubstring(s, n);
		if (pos == null) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			System.out.println(pos[0] + " " + pos[1]);
		}
		sc.close();
	}

	private static int[] findSubstring(String s, int n) {
		char currentChar = s.charAt(0);
		int currentIndex = 0;
		for (int index = 1; index < n; index++) {
			char nextChar = s.charAt(index);
			if (currentChar > nextChar) {
				return new int[] { currentIndex + 1, index + 1 };
			} else {
				currentChar = nextChar;
				currentIndex = index;
			}
		}
		return null;
	}

}
