/**
 * 
 */
package googleCodeJam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class DoubleOrOneThing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			String s = sc.next();
			char [] array = s.toCharArray();
			Arrays.sort(array);
			if (array[0] == array[array.length - 1]) {
				System.out.println("Case #" + t + ": " + s);
			}
			else {
				System.out.println("Case #" + t + ": " + findTheString(s));
			}
		}
	}

	private static String findTheString(String s) {
		String t = "";
		for (int i  = s.length() - 1; i >= 0; i--) {
			String current1 = s.charAt(i) + t;
			String current2 = s.charAt(i) + (s.charAt(i) + t);
			t = current1.compareTo(current2) < 0 ? current1 : current2;
		}
		return t;
	}

}
