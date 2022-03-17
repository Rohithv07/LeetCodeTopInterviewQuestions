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
public class MakeAP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			double a1 = sc.nextDouble();
			double a2 = sc.nextDouble();
			double a3 = sc.nextDouble();
			if (a2 - a1 == a3 - a2) {
				System.out.println("YES");
			} else {
				double m1 = (2 * a2 - a3) / (a1);
				double m2 = (a3 + a1) / (2 * a2);
				double m3 = (2 * a2 - a1) / (a3);
				//System.out.println(m1 + " " + m2 + " " + m3);
				if ((m1 > 1.0 && m1 % 1.0 == 0) || (m2 > 1.0 && m2 % 1.0 == 0) || (m3 > 1.0 && m3 % 1.0 == 0)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
}
