package problemsolving;

import java.util.Scanner;

/**
 * 
 * @author rohithvazhathody
 *
 *
 */
public class InfinityTable {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long k = sc.nextLong();
			int a = 1;
			int x = 1;
			int i = 1;
			while (k >= x + a) {
				x += a;
				a += 2;
				i += 1;
			}
			long factor = k - x + 1;
			if (factor <= i) {
				System.out.println(factor + " " + i);
			}
			else {
				System.out.println(i + " " + (i - (factor - i)));
			}
		}
	}
}
