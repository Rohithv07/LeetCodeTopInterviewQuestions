/**
 * 
 */
package problemsolving2;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author rohithvazhathody
 *
 *
 */
public class CaseZeroesAndOnes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		if (n == 1) {
			System.out.println("1");
		} else {
			int count0 = 0;
			int count1 = 0;
			for (char ch : s.toCharArray()) {
				if (ch == '0') {
					count0++;
				} else {
					count1++;
				}
			}
			System.out.println(Math.abs(count0 - count1));
		}
	}
}
