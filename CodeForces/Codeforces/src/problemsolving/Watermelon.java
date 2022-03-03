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
public class Watermelon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		if (w == 2) {
			System.out.println("NO");
		}
		else if (w % 2 == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
