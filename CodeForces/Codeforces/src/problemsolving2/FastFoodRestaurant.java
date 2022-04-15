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
public class FastFoodRestaurant {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if (a == 0 && b == 0 && c == 0) {
				System.out.println(0);
			} else {
				if (b > c && b > a) {
					int k = a;
					a = b;
					b = k;
				}
				if (c > b && c > a) {
					int k = a;
					a = c;
					c = k;
				}

				int res = 0;
				if (a >= 1) {
					a--;
					res++;
				}
				if (b >= 1) {
					b--;
					res++;
				}
				if (c >= 1) {
					c--;
					res++;
				}
				if (a >= 1 && b >= 1) {
					a--;
					b--;
					res++;
				}
				if (a >= 1 && c >= 1) {
					a--;
					c--;
					res++;
				}
				if (c >= 1 && b >= 1) {
					c--;
					b--;
					res++;
				}
				if (a >= 1 && b >= 1 && c >= 1)
					res++;
				System.out.println(res);
			}
		}
	}
}
