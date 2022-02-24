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
public class TeamCompositionProgrammersMathematician {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long p = sc.nextInt();
			long m = sc.nextInt();
			System.out.println(Math.min(Math.min(m, p), (m + p) / 4));
		}
	}
}
