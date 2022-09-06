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
public class DeleteFromTheLeft {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();
		int w = 0;
		while (true) {
			int i = s.length() - w - 1;
			int j = t.length() - w - 1;
			if (i >= 0 && j >= 0 && s.charAt(i) == t.charAt(j)) {
				w++;
			} else {
				break;
			}
		}
		System.out.println(s.length() + t.length() - 2 * w);
	}
}
