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
public class Contest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		long d = sc.nextLong();
		long calV1 = (3 * b) / 10;
		long calV2 = b - ((b / 250) * d);
		long calM1 = (3 * a) / 10;
		long calM2 = a - ((a / 250) * c);
		long max1 = Math.max(calV1, calV2);
		long max2 = Math.max(calM1, calM2);
		if (max1 > max2) {
			System.out.println("Vasya");
		} else if (max1 < max2) {
			System.out.println("Misha");
		} else {
			System.out.println("Tie");
		}
	}
}
