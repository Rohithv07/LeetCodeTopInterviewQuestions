/**
 * @author rohithvazhathody
 * @date 18 Jan 2026
 * Project: CodeforceContestes
 * File: PerfectRoot.java
 */

package contests.round1074;

import java.util.Scanner;

/**
 * 
 */
public class PerfectRoot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			for (int index = 1; index <= n; index++) {
				System.out.print(index + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
