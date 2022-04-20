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
public class MagicNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(isMagic(s) ? "YES" : "NO");
	}

	private static boolean isMagic(String s) {
		for (char ch : s.toCharArray()) {
			if (ch != '1' && ch != '4') {
				return false;
			}
		}
		if (s.charAt(0) != '1') {
			return false;
		}
		if (s.contains("444")) {
			return false;
		}
		return true;

	}
}
