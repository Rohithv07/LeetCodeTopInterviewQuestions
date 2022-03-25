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
public class ABCString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			System.out.println(findIfPossible(s));
		}
	}

	public static String findIfPossible(String s) {
		int n = s.length();
		if (s.charAt(0) == s.charAt(n - 1)) {
			return "NO";
		}
		int index1 = 0;
		int index2 = 0;
		boolean pos1 = true;
		boolean pos2 = true;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == s.charAt(0)) {
				index1++;
				index2++;
			} else if (s.charAt(i) == s.charAt(n - 1)) {
				index1--;
				index2--;
			} else {
				index1++;
				index2--;
			}
			if (index1 < 0) {
				pos1 = false;
			}
			if (index2 < 0) {
				pos2 = false;
			}
		}
		if (index1 != 0) {
			pos1 = false;
		}
		if (index2 != 0) {
			pos2 = false;
		}
		return pos1 || pos2 ? "YES" : "NO";
	}
}
