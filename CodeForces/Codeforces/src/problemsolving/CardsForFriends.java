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
public class CardsForFriends {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int width = sc.nextInt();
			int height = sc.nextInt();
			int n = sc.nextInt();
			int count = 1;
			while (width % 2 == 0) {
				width /= 2;
				count *= 2;
			}
			while (height % 2 == 0) {
				height /= 2;
				count *= 2;
			}
			System.out.println(count >= n ? "YES" : "NO");

		}
	}
}
