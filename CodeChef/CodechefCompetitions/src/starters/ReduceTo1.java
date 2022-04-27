/**
 * 
 */
package starters;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class ReduceTo1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			long sq = (long) Math.sqrt(n);
			if (n == 1)
				System.out.println(0);
			else if (n % 2 == 1)
				System.out.println(1);
			else if (sq * sq == n)
				System.out.println(1);
			else {
				while (n % 4 == 0)
					n = n / 4;
				if (n % 2 == 1)
					System.out.println(2);
				else
					System.out.println(-1);
			}
		}
	}
}
