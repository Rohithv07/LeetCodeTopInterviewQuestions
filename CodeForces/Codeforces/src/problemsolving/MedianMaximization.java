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
public class MedianMaximization {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int m = n / 2 + 1;
			System.out.println(s / m);
		}
	}
}
