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
public class HQ9Plus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(isCompile(s) ? "YES" : "NO");
	}

	private static boolean isCompile(String s) {
		for (char ch : s.toCharArray()) {
			if (ch == 'H' || ch == 'Q' || ch == '9') {
				return true;
			}
		}
		return false;
	}
}
