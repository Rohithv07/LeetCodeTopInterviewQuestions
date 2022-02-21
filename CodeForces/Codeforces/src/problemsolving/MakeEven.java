/**
 * 
 */
package problemsolving;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class MakeEven {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			int length = s.length();
			if ((s.charAt(length - 1) - '0') % 2 == 0) {
				System.out.println("0");
			} else if (((s.charAt(0) - '0')) % 2 == 0) {
				System.out.println("1");
			} else {
				boolean isEvenFound = false;
				for (char ch : s.toCharArray()) {
					if ((ch - '0') % 2 == 0) {
						isEvenFound = true;
						break;
					}
				}
				System.out.println(isEvenFound ? "2" : "-1");
			}
		}
	}
}
