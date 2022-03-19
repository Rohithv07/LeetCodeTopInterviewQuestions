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
public class ABBalance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			int length = s.length();
			if (s.charAt(0) == s.charAt(length - 1)) {
				System.out.println(s);
			} else {
				char[] array = s.toCharArray();
				if (array[0] == 'a') {
					array[0] = 'b';
				} else {
					array[0] = 'a';
				}
				System.out.println(new String(array));
			}
		}
	}
}
