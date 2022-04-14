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
public class GameWithSticks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int min = Math.min(n, m);
		System.out.println(min % 2 == 0 ? "Malvika" : "Akshat");

	}
}
