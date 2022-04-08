/**
 * 
 */
package problemsolving2;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class Football {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(isDangerous(s) ? "YES" : "NO");
	}

	private static boolean isDangerous(String s) {
		if (s.length() < 7) {
			return false;
		}
		int i = 1;
		int count = 1;
		int previous = s.charAt(0) - '0';
		while (i < s.length()) {
			int current = s.charAt(i) - '0';
			if (previous == current) {
				count += 1;
			} else {
				previous = current;
				count = 1;
			}
			if (count >= 7) {
				return true;
			}
			i++;
		}
		return false;
	}
}
