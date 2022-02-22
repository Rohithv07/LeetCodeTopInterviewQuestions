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
public class RegularBracketConsequnces {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				fillBracket(i);
				fillBracket(n - i);
				System.out.println();
			}
		}
	}

	public static void fillBracket(int index) {
		for (int i = 0; i < index; i++) {
			System.out.print("(");
		}
		for (int i = 0; i < index; i++) {
			System.out.print(")");
		}
	}
}
